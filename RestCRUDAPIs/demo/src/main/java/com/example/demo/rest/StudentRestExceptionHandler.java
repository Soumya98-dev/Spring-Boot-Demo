package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse res = new StudentErrorResponse();
        res.setStatus(HttpStatus.NOT_FOUND.value());
        res.setMessage(exc.getMessage());
        res.setTimeStamp(System.currentTimeMillis());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(res);

    }
}