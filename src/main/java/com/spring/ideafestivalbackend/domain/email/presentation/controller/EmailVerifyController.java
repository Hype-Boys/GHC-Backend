package com.spring.ideafestivalbackend.domain.email.presentation.controller;

import com.spring.ideafestivalbackend.domain.email.service.EmailVerifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;

@RestController
@RequiredArgsConstructor
@RequestMapping("/verify-email")
public class EmailVerifyController {
    private EmailVerifyService emailVerifyService;

    @RequestMapping(method = RequestMethod.HEAD)
    public ResponseEntity<Void> verifyEmail(@Email @RequestParam String email, @RequestParam String authCode) {
        emailVerifyService.verificationMail(email, authCode);
        return ResponseEntity.ok().build();
    }

}
