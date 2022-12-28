package com.spring.ideafestivalbackend.domain.user.exception;

import com.spring.ideafestivalbackend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NotVerifyEmailException extends RuntimeException{
    private ErrorCode errorCode;

    public NotVerifyEmailException(String message){
        super(message);
        this.errorCode = ErrorCode.NOT_VERIFY_EMAIL;
    }
}
