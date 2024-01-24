package com.example.backendassessment.service;

import com.example.backendassessment.dto.account.GetBalanceResponse;
import com.example.backendassessment.dto.account.OpenAccountResponse;

import java.math.BigDecimal;

public interface AccountService {
    OpenAccountResponse openAccount();
    GetBalanceResponse getBalance(String accountId);
}
