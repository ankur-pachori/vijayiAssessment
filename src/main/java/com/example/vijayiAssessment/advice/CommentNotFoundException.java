package com.example.vijayiAssessment.advice;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommentNotFoundException extends RuntimeException {
    private String errorMessage;
    private String errorCode;
    public CommentNotFoundException(String errorMessage, String errorCode) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public CommentNotFoundException() {

    }
}
