package com.example.backendassessment.constant;


import com.example.backendassessment.utils.Value;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


public class ResponseCodes {
    @Value(Value = "success")
    public static final int SUCCESS = 200;
    @Value(Value = "account not found")
    public static final int ACCOUNT_NOT_FOUND = 405;
    @Value(Value = "no sufficient balance")
    public static final int NO_SUFFICIENT_BALANCE = 406;
    @Value(Value = "invalid amount")
    public static final String INVALID_AMOUNT = "408";
    @Value(Value = "invalid account id")
    public static final String INVALID_ACCOUNT_ID = "410";
    @Value(Value = "internal error")
    public static final int INTERNAL_ERROR = 500;

    public static String getDesc(int constantValue) {
        String Desc = "";
        Field[] interfaceFields = ResponseCodes.class.getFields();
        for (Field f : interfaceFields) {
            try {
                if (Integer.parseInt(f.get(null).toString()) == constantValue) {
                    Value annotation = f.getAnnotation(Value.class);
                    if (annotation != null) {
                        Desc = annotation.Value();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return Desc;

    }

}
