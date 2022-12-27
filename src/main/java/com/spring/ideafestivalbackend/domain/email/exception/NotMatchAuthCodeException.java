package com.spring.ideafestivalbackend.domain.email.exception;

import com.spring.ideafestivalbackend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NotMatchAuthCodeException extends RuntimeException{
    private final ErrorCode errorCode;

    public NotMatchAuthCodeException(String message){
        super(message);
        this.errorCode = ErrorCode.NOTMATCH_AUTHCODE;
    }
}
