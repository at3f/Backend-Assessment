package com.example.backendassessment.dto;

import com.example.backendassessment.constant.ResponseCodes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Response {
    private int responseCode;
    private String responseMessage;
    public Response(int responseCode){
        this.responseCode=responseCode;
        responseMessage = ResponseCodes.getDesc(responseCode);
    }
    public void setResponseCode(int responseCode) {
        this.responseCode=responseCode;
        responseMessage = ResponseCodes.getDesc(responseCode);
    }
}
