package com.example.backendassessment.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static com.example.backendassessment.constant.GlobalConstants.ACCOUNT_NUMBER_LENGTH;
import static com.example.backendassessment.constant.ResponseCodes.INVALID_ACCOUNT_ID;
import static com.example.backendassessment.constant.ResponseCodes.INVALID_AMOUNT;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationRequest {
    @Length(min = ACCOUNT_NUMBER_LENGTH,max = ACCOUNT_NUMBER_LENGTH, message = INVALID_ACCOUNT_ID)
    @NotNull(message = INVALID_ACCOUNT_ID)
    private String accountId;
    @DecimalMin(value = "0.0", inclusive = false, message = INVALID_AMOUNT)
    @NotNull(message = INVALID_AMOUNT)
    private BigDecimal amount;
}
