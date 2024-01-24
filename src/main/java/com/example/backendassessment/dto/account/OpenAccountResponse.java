package com.example.backendassessment.dto.account;

import com.example.backendassessment.dto.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenAccountResponse extends Response {
    private String accountId;
    public OpenAccountResponse(int responseCode) {
        super(responseCode);
    }
}
