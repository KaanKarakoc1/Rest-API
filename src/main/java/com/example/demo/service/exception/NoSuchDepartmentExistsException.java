package com.example.demo.service.exception;

public class NoSuchDepartmentExistsException extends RuntimeException {

    private String message;

    public NoSuchDepartmentExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
