package com.example.demo.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoSuchDepartmentExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponseImpl
    handleException(NoSuchDepartmentExistsException ex) {
        return new ErrorResponseImpl(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(value = WrongInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponseImpl
    handleException(WrongInputException ex) {
        return new ErrorResponseImpl(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(value = DepartmentAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponseImpl
    handleDepartmentAlreadyExistsException(DepartmentAlreadyExistsException ex) {
        return new ErrorResponseImpl(HttpStatus.CONFLICT.value(), ex.getMessage());
    }


    @ExceptionHandler(value = EmployeeAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponseImpl
    handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException ex) {
        return new ErrorResponseImpl(HttpStatus.CONFLICT.value(), ex.getMessage());
    }
}