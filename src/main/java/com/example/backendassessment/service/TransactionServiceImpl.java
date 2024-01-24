package com.example.backendassessment.service;

import com.example.backendassessment.constant.TransactionType;
import com.example.backendassessment.dto.transaction.OperationRequest;
import com.example.backendassessment.dto.transaction.OperationResponse;
import com.example.backendassessment.model.Account;
import com.example.backendassessment.model.Transaction;
import com.example.backendassessment.repository.AccountRepository;
import com.example.backendassessment.repository.TransactionRepository;
import com.example.backendassessment.utils.BasicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import static com.example.backendassessment.constant.ResponseCodes.*;
import static com.example.backendassessment.constant.TransactionType.*;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;
    private OperationResponse withdraw(String accountId, BigDecimal amount) {
        OperationResponse response = new OperationResponse(SUCCESS);
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if(optionalAccount.isPresent()){
            Account account = optionalAccount.get();

            if(isAccountHasSufficientBalance(account,amount)){
                account.setBalance(account.getBalance().subtract(amount));
                Transaction transaction = new Transaction();
                transaction.setAmount(amount);
                transaction.setAccount(account);
                transaction = transactionRepository.save(transaction);
                response.setTransactionId(transaction.getId());
            }else
                response.setResponseCode(NO_SUFFICIENT_BALANCE);

        }else
            response.setResponseCode(ACCOUNT_NOT_FOUND);
        return response;
    }

    private OperationResponse deposit(String accountId, BigDecimal amount) {
        OperationResponse response = new OperationResponse(SUCCESS);
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if(optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            account.setBalance(account.getBalance().add(amount));
            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            transaction.setAccount(account);
            transaction = transactionRepository.save(transaction);
            response.setTransactionId(transaction.getId());
        }else
            response.setResponseCode(ACCOUNT_NOT_FOUND);
        return response;
    }
    private final Map<String, ReentrantLock> accountLocks = new ConcurrentHashMap<>();

    @Override
    public OperationResponse doTransaction(OperationRequest request, TransactionType transactionType) {
        accountLocks.putIfAbsent(request.getAccountId(), new ReentrantLock());

        ReentrantLock accountLock = accountLocks.get(request.getAccountId());

        accountLock.lock();
        try {
            int status = BasicUtils.validate(request);
            if(status==SUCCESS)
                return  transactionType.equals(DEPOSIT) ?
                        deposit(request.getAccountId() ,request.getAmount()) :
                        withdraw(request.getAccountId() ,request.getAmount());
            else
                return new OperationResponse(status);

        }catch (Exception e){
            return new OperationResponse(INTERNAL_ERROR);
        }finally {
            accountLock.unlock();
        }
    }
    private boolean isAccountHasSufficientBalance(Account account,BigDecimal amount){
        return !(account.getBalance().compareTo(amount)<0);
    }
}
