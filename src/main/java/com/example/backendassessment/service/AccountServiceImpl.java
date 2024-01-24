package com.example.backendassessment.service;

import com.example.backendassessment.dto.account.GetBalanceResponse;
import com.example.backendassessment.dto.account.OpenAccountResponse;
import com.example.backendassessment.model.Account;
import com.example.backendassessment.repository.AccountRepository;
import com.example.backendassessment.utils.BasicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

import static com.example.backendassessment.constant.ResponseCodes.*;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository repository;
    @Override
    public OpenAccountResponse openAccount() {
        OpenAccountResponse response = new OpenAccountResponse(SUCCESS);
        try{
            Account account = new Account();
            String accountId = BasicUtils.generateBankAccountId();
            account.setId(accountId);
            repository.save(account);
            response.setAccountId(accountId);
        }catch (Exception e){
            response.setResponseCode(INTERNAL_ERROR);
        }

        return response;
    }

    @Override
    public GetBalanceResponse getBalance(String accountId) {
        GetBalanceResponse response = new GetBalanceResponse(SUCCESS);
        try{
            Optional<Account> account = repository.findById(accountId);
            response.setBalance(account.map(Account::getBalance).orElse(null));
        }catch (Exception e){
            response.setResponseCode(INTERNAL_ERROR);
        }
        return response;
    }
}
