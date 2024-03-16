package com.example.demo.service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseImpl  {

    private int statusCode;
    private String message;

    public ErrorResponseImpl(String message){
        super();
        this.message = message;
    }

}