package com.spring.ideafestivalbackend.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenExpirationException extends RuntimeException{
    private final ErrorCode errorCode;

    public TokenExpirationException(String message){
        super(message);
        errorCode = ErrorCode.TOKEN_EXPIRATION;
    }
}
