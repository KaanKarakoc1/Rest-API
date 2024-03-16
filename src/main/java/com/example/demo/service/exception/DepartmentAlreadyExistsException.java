package com.example.demo.service.exception;

public class DepartmentAlreadyExistsException extends RuntimeException {

    private String message;

    public DepartmentAlreadyExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}