package com.example.backendassessment.dto.transaction;

import com.example.backendassessment.dto.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationResponse extends Response {
    private Long transactionId;
    public OperationResponse(int responseCode) {
        super(responseCode);
    }
}
