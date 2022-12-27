package com.spring.ideafestivalbackend.domain.board.presentation.controller;

import com.spring.ideafestivalbackend.domain.board.entity.BoardEntity;
import com.spring.ideafestivalbackend.domain.board.presentation.dto.request.BoardRequest;
import com.spring.ideafestivalbackend.domain.board.presentation.dto.request.ModifyBoardRequest;
import com.spring.ideafestivalbackend.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody @Valid BoardRequest request) {
        boardService.add(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BoardEntity>> getBoards() {
        return ResponseEntity.ok(boardService.getBoards());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<BoardEntity> getBoard(@PathVariable("postId") Long postId) {
        return ResponseEntity.ok(boardService.getBoard(postId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Long id) {
        boardService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, ModifyBoardRequest modifyBoardRequest) {
        boardService.updateBoard(id, modifyBoardRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}