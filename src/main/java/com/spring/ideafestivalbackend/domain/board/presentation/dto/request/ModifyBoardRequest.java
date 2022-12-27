package com.spring.ideafestivalbackend.domain.board.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ModifyBoardRequest {

    private final String title;

    private final String content;

}
