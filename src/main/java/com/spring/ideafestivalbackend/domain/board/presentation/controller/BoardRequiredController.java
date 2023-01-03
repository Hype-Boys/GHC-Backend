package com.spring.ideafestivalbackend.domain.board.presentation.controller;


import com.spring.ideafestivalbackend.domain.board.presentation.dto.request.BoardRequest;
import com.spring.ideafestivalbackend.domain.board.service.BoardService;
import com.spring.ideafestivalbackend.domain.board.service.impl.BoardServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/WEBFLIX/require")
public class BoardRequiredController {
    private final BoardService boardService;
    @GetMapping
    public ResponseEntity viewAll(){
        boardService.viewAll();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity viewOne(@PathVariable Long id){
        boardService.viewOne(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/write/{id}")
    public ResponseEntity write(@PathVariable Long id){
        boardService.write(id);
        return ResponseEntity.ok(boardService.write(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody @Valid BoardRequest boardRequest){
        boardService.add(boardRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> edit(@PathVariable Long id, @RequestBody @Valid BoardRequest boardRequest){
        boardService.edit(id, boardRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boardService.delete(id);
        return ResponseEntity.ok(null);
    }

}
