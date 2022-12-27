package com.spring.ideafestivalbackend.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOTMATCH_AUTHCODE("인증번호가 일치하지 않습니다", 409),
    CODE_EXPIRED("인증번호가 만료되었습니다",409);

    private final String message;
    private final int status;
}
