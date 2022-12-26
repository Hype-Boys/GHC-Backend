package com.spring.ideafestivalbackend.domain.auth.exception;

import com.spring.ideafestivalbackend.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BlackListAlreadyExistException extends RuntimeException{
    private final ErrorCode errorCode;

    public BlackListAlreadyExistException(String message){
        super(message);
        this.errorCode = ErrorCode.BLACK_LIST_ALREADY_EXIST;
    }
}
