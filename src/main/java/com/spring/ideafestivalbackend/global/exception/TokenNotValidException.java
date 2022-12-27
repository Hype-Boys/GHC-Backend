package com.spring.ideafestivalbackend.global.exception;

import com.spring.ideafestivalbackend.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenNotValidException extends RuntimeException{
    private final ErrorCode errorCode;

    public TokenNotValidException(String message){
        super(message);
        this.errorCode = ErrorCode.TOKEN_NOT_VALID;
    }
}
