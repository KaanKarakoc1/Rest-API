package com.example.demo.service.exception;

public class EmployeeAlreadyExistsException extends RuntimeException{
    private String message;
    public EmployeeAlreadyExistsException(String msg){
        super(msg);
        this.message = msg;
    }
}
