package com.example.backendassessment.utils;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Objects;
import java.util.Random;

import static com.example.backendassessment.constant.GlobalConstants.*;
import static com.example.backendassessment.constant.ResponseCodes.SUCCESS;

public class BasicUtils {
    private static final Validator javaxValidator = Validation.buildDefaultValidatorFactory().getValidator();
    private static final SpringValidatorAdapter validator = new SpringValidatorAdapter(javaxValidator);
    public static String generateBankAccountId() {
        return generateRandomNumericString();
    }

    private static String generateRandomNumericString() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
            int digit = random.nextInt(10);
            stringBuilder.append(digit);
        }

        return stringBuilder.toString();
    }
    public static int validate(Object entry) {
        int response = SUCCESS;
        Errors errors = new BeanPropertyBindingResult(entry, entry.getClass().getName());
        validator.validate(entry, errors);
        if (!errors.getAllErrors().isEmpty()) {
            response = Integer.parseInt(Objects.requireNonNull(errors.getAllErrors().get(0).getDefaultMessage()));
        }
        return response;
    }
}
