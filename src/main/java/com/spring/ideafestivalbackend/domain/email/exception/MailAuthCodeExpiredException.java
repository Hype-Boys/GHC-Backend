package com.spring.ideafestivalbackend.domain.email.exception;

import com.spring.ideafestivalbackend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class MailAuthCodeExpiredException extends RuntimeException{
    private final ErrorCode errorCode;

    public MailAuthCodeExpiredException(String message){
        super(message);
        this.errorCode = ErrorCode.CODE_EXPIRED;
    }
}