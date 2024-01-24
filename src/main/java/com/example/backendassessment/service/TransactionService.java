package com.example.backendassessment.service;

import com.example.backendassessment.constant.TransactionType;
import com.example.backendassessment.dto.transaction.OperationRequest;
import com.example.backendassessment.dto.transaction.OperationResponse;

import java.math.BigDecimal;

public interface TransactionService {
    OperationResponse doTransaction(OperationRequest request, TransactionType transactionType);
}
