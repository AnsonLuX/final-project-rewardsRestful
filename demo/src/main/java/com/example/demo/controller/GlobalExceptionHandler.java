package com.example.demo.controller;

import com.example.demo.exception.CustomerExistsException;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.exception.DBOperationException;
import com.example.demo.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerCustomerNotExists(Exception exc) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerExistsException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerCustomerExistsException(Exception exc) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DBOperationException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerDatabaseOperationFailure(Exception exc) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}