package com.spring.ideafestivalbackend.domain.board.service;

import com.spring.ideafestivalbackend.domain.board.entity.BoardEntity;
import com.spring.ideafestivalbackend.domain.board.presentation.dto.request.BoardRequest;
import com.spring.ideafestivalbackend.domain.board.presentation.dto.response.BoardResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    List<BoardEntity> viewAll();
    Optional<BoardEntity> viewOne(Long id);
    Object write(Long id);
    @Transactional
    void edit(Long id, BoardRequest boardRequest);

    void add(BoardRequest boardRequest);
    void delete(Long id);
}
