package com.spring.ideafestivalbackend.domain.email.presentation.controller;


import com.spring.ideafestivalbackend.domain.email.presentation.dto.EmailDto;
import com.spring.ideafestivalbackend.domain.email.service.EmailSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/send-email")
public class EmailSendController {

    @Autowired
    private EmailSendService emailSendService;

    @PostMapping(value = "/send" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendEmail(@RequestBody @Valid EmailDto emailDto) {
        emailSendService.sendMail(emailDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}