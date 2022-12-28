package com.spring.ideafestivalbackend.domain.board.service;

import com.spring.ideafestivalbackend.domain.board.entity.BoardEntity;
import com.spring.ideafestivalbackend.domain.board.repository.BoardRepository;
import com.spring.ideafestivalbackend.domain.board.presentation.dto.request.BoardRequest;
import com.spring.ideafestivalbackend.domain.board.presentation.dto.request.ModifyBoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    @Transactional(rollbackFor = Exception.class)
    public void add(BoardRequest request){
        BoardEntity board = BoardEntity.builder()
                .username(request.getUsername())
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        boardRepository.save(board);
    }
    @Transactional
    public void delete(Long boardId){
        BoardEntity board = boardRepository.findById(boardId).get();
        boardRepository.delete(board);
    }

    @Transactional
    public List<BoardEntity> getBoards() {
        return boardRepository.findAll();
    }
    @Transactional
    public BoardEntity getBoard(Long postId){
        return boardRepository.findById(postId).orElseThrow(() -> new RuntimeException());
    }
    @Transactional(rollbackFor = Exception.class)
    public void updateBoard(Long id, ModifyBoardRequest request) {
        BoardEntity board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException());
        board.update(request.getTitle(), request.getContent());
    }
}