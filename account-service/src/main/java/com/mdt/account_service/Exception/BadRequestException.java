package com.mdt.account_service.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Invalid input")
public class BadRequestException extends Exception{
    private static final long serialVersionUID = 1L;
    public BadRequestException(){

    }
}