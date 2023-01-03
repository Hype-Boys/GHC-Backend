package com.spring.ideafestivalbackend.domain.board.presentation.controller;

import com.spring.ideafestivalbackend.domain.board.presentation.dto.request.BoardRequest;
import com.spring.ideafestivalbackend.domain.board.service.impl.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/WEBFLIX/board")
@RequiredArgsConstructor
public class BoardController {
        private final BoardServiceImpl boardService;
        @GetMapping
        public ResponseEntity viewAll(){
            boardService.viewAll();
            return ResponseEntity.ok(HttpStatus.OK);
        }
        @GetMapping("/{id}")
        public ResponseEntity viewOne(@PathVariable Long seq){
            boardService.viewOne(seq);
            return ResponseEntity.ok(HttpStatus.OK);
        }

        @GetMapping("/write/{id}")
        public ResponseEntity write(@PathVariable Long seq){
            boardService.write(seq);
            return ResponseEntity.ok(boardService.write(seq));
        }

        @PostMapping("/add")
        public ResponseEntity<Void> add(@RequestBody @Valid BoardRequest boardRequest){
            boardService.add(boardRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Void> edit(@PathVariable Long seq, @RequestBody @Valid BoardRequest boardRequest){
            boardService.edit(seq,boardRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id){
            boardService.delete(id);
            return ResponseEntity.ok(null);
        }
}