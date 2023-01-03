package com.spring.ideafestivalbackend.domain.board.service.impl;

import com.spring.ideafestivalbackend.domain.board.entity.BoardEntity;
import com.spring.ideafestivalbackend.domain.board.presentation.dto.request.BoardRequest;
import com.spring.ideafestivalbackend.domain.board.presentation.dto.response.BoardResponse;
import com.spring.ideafestivalbackend.domain.board.repository.BoardRepository;
import com.spring.ideafestivalbackend.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public List<BoardEntity> viewAll(){
        List<BoardEntity> boardEntity = boardRepository.findAll();
        return boardEntity;
    }

    @Override
    @Transactional
    public Optional<BoardEntity> viewOne(Long id){
        Optional<BoardEntity> boardEntity = boardRepository.findById(id);
        return boardEntity;
    }
    @Override
    @Transactional
    public Object write(Long id){
        return boardRepository.findById(id).map(board->{
            BoardResponse boardResponse = new BoardResponse();
            boardResponse.setContent(board.getContent());
            boardResponse.setTitle(board.getTitle());
            boardResponse.setUsername(board.getUserName());
            boardResponse.setId(board.getId());
            return boardResponse;
        }).get();
    }



    @Override
    @Transactional
    public void edit(Long id, BoardRequest boardRequest) {
        BoardEntity getEntity = boardRepository.findById(id)
                .orElseThrow( ()->new RuntimeException());
        getEntity.update(boardRequest.getContent(), boardRequest.getTitle(), boardRequest.getUsername());
        boardRepository.save(getEntity);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(BoardRequest boardRequest) {
        BoardEntity boardEntity = BoardEntity.builder()
                .title(boardRequest.getTitle())
                .content(boardRequest.getContent())
                .userName(boardRequest.getUsername())
                .build();

        boardRepository.save(boardEntity);
    }


    @Override
    @Transactional
    public void delete(Long id){
        boardRepository.deleteById(id);
    }
}