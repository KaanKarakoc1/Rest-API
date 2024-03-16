package com.example.demo.service.exception;

public class WrongInputException extends RuntimeException{
    private String message;

    public WrongInputException(String msg){
        super(msg);
        this.message = msg;
    }
}
