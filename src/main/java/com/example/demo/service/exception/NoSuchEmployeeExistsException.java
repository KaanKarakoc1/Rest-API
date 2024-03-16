package com.example.demo.service.exception;

public class NoSuchEmployeeExistsException extends RuntimeException{

    private String message;

    public NoSuchEmployeeExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
