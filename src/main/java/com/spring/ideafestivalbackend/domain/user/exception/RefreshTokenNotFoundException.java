package com.spring.ideafestivalbackend.domain.user.exception;

import com.spring.ideafestivalbackend.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RefreshTokenNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;

    public RefreshTokenNotFoundException(String message){
        super(message);
        this.errorCode = ErrorCode.REFRESH_TOKEN_NOT_FOUND;
    }
}
