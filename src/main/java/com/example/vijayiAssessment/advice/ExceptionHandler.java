package com.example.vijayiAssessment.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<?> handleFieldsEmptyException(CommentNotFoundException exception, WebRequest request){

        return new ResponseEntity<String>(exception.getErrorMessage(),HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleCarNotFound(UserNotFoundException exception, WebRequest request){

        return new ResponseEntity<String>(exception.getErrorMessage(),HttpStatus.BAD_REQUEST);
    }
}
