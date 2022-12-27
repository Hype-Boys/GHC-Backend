package com.spring.ideafestivalbackend.domain.board.presentation.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {
    @NotNull
    private String title;
    @NotNull
    private String username;
    @NotNull
    private String content;
}
