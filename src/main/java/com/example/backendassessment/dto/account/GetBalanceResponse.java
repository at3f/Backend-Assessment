package com.example.backendassessment.dto.account;

import com.example.backendassessment.dto.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static com.example.backendassessment.constant.ResponseCodes.ACCOUNT_NOT_FOUND;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBalanceResponse extends Response {
    private BigDecimal balance = BigDecimal.valueOf(0);
    public GetBalanceResponse(int responseCode) {
        super(responseCode);
    }
    public void setBalance(BigDecimal balance) {
        if(balance==null)
            super.setResponseCode(ACCOUNT_NOT_FOUND);
        else
            this.balance = balance;
    }
}
