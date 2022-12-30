package com.spring.ideafestivalbackend.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOTMATCH_AUTHCODE("인증번호가 일치하지 않습니다", 400),

    WRONG_PASSWORD("비밀번호가 올바르지 않습니다.", 400),

    CODE_EXPIRED("인증번호가 만료되었습니다",409),

    USER_NOT_FOUD("유저를 찾을 수 없습니다", 404),

    NOT_VERIFY_EMAIL("이메일이 확인되지 않았습니다.", 401),

    TOKEN_NOT_VALID("토큰이 유효 하지 않습니다.", 401),

    BLACK_LIST_ALREADY_EXIST("블랙리스트에 이미 존재합니다.",409),

    EMAIL_ALREADY_EXIST("존재하는 이메일 입니다.", 409),

    TOKEN_EXPIRATION("토큰이 만료 되었습니다.", 401),

    REFRESH_TOKEN_NOT_FOUND("리프레시 토큰을 찾을 수가 없습니다.",404),

    MANY_REQUEST_EMAIL_AUTH("15분마다 최대 5번 이메일 인증을 요청할 수 있습니다", 429),

    NOT_NULL("null이 아닌 값, 공백이 아닌 문자를 하나 이상 포함해야 합니다",400);

    private final String message;
    private final int status;
}
