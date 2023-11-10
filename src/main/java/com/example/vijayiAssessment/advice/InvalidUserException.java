package com.example.vijayiAssessment.advice;

import lombok.Data;
import org.springframework.stereotype.Component;
@Component
@Data
public class InvalidUserException extends RuntimeException {
    private String errorMessage;
    private String errorCode;
    public InvalidUserException(String errorMessage, String errorCode) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public InvalidUserException() {

    }
}
