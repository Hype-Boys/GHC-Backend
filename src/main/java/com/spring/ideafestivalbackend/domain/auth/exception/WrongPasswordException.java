package com.spring.ideafestivalbackend.domain.auth.exception;

import com.spring.ideafestivalbackend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class WrongPasswordException extends RuntimeException{
    private ErrorCode errorCode;

    public WrongPasswordException(String message){
        super(message);
        this.errorCode = ErrorCode.WRONG_PASSWORD;
    }
}
