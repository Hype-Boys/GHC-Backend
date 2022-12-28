package com.spring.ideafestivalbackend.domain.auth.presentation.controller;

import com.spring.ideafestivalbackend.domain.auth.presentation.dto.request.UserSignInRequest;
import com.spring.ideafestivalbackend.domain.auth.presentation.dto.request.UserSignupRequest;
import com.spring.ideafestivalbackend.domain.auth.presentation.dto.response.NewTokenResponse;
import com.spring.ideafestivalbackend.domain.auth.presentation.dto.response.UserSignInResponse;
import com.spring.ideafestivalbackend.domain.auth.service.RenewTokenService;
import com.spring.ideafestivalbackend.domain.auth.service.SignInService;
import com.spring.ideafestivalbackend.domain.auth.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final SignInService signInService;
    private final SignUpService signUpService;
    private final RenewTokenService renewTokenService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody @Valid UserSignupRequest userSignupRequest){
        signUpService.singUp(userSignupRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<UserSignInResponse> signIn(@RequestBody @Valid UserSignInRequest userSignInRequest){
        UserSignInResponse data = signInService.signIn(userSignInRequest);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @PatchMapping
    public ResponseEntity<NewTokenResponse> reIssueToken(@RequestHeader("RefreshToken") String token) {
        NewTokenResponse reIssueToken = renewTokenService.tokenReissuance(token);
        return new ResponseEntity<>(reIssueToken, HttpStatus.OK);
    }
}
