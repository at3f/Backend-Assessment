package com.example.backendassessment.controller;

import com.example.backendassessment.dto.transaction.OperationRequest;
import com.example.backendassessment.dto.transaction.OperationResponse;
import com.example.backendassessment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.backendassessment.constant.TransactionType.DEPOSIT;
import static com.example.backendassessment.constant.TransactionType.WITHDRAWAL;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit")
    public OperationResponse deposit(@RequestBody OperationRequest request) {
        return transactionService.doTransaction(request, DEPOSIT);
    }

    @PostMapping("/withdraw")
    public OperationResponse withdraw(@RequestBody OperationRequest request) {
        return transactionService.doTransaction(request, WITHDRAWAL);
    }
}
