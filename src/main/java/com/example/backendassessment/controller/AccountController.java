package com.example.backendassessment.controller;

import com.example.backendassessment.dto.account.GetBalanceResponse;
import com.example.backendassessment.dto.account.OpenAccountResponse;
import com.example.backendassessment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/open")
    public OpenAccountResponse openAccount() {
        return accountService.openAccount();
    }

    @GetMapping("/{accountId}/balance")
    public GetBalanceResponse getBalance(@PathVariable String accountId) {
        return accountService.getBalance(accountId);
    }
}
