package com.example.demo.exception;

public class DBOperationException extends RuntimeException{
    private String errorMessage;

    public DBOperationException() {
        super();
    }

    public DBOperationException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage(){
        return errorMessage;
    }
}
