package com.spring.ideafestivalbackend.domain.board.presentation.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardResponse {
    private Long id;
    private String title;
    private String username;
    private String content;
}
