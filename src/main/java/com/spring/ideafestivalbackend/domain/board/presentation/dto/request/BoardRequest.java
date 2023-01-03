package com.spring.ideafestivalbackend.domain.board.presentation.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String username;

    @NotBlank
    private String content;
}
