package com.spring.ideafestivalbackend.domain.board.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorMessage {

    private final String message;
    private final int status;
}