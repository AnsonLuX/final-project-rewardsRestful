package com.example.demo.exception;

public class CustomerExistsException extends RuntimeException{
    private String errorMessage;
    public CustomerExistsException() {
        super();
    }
    public CustomerExistsException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage(){
        return errorMessage;
    }
}
