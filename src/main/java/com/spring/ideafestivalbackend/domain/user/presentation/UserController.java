package com.spring.ideafestivalbackend.domain.user.presentation;


import com.spring.ideafestivalbackend.domain.user.presentation.dto.reponse.NewTokenResponse;
import com.spring.ideafestivalbackend.domain.user.presentation.dto.reponse.SignInResponse;
import com.spring.ideafestivalbackend.domain.user.presentation.dto.request.ChangePasswordRequest;
import com.spring.ideafestivalbackend.domain.user.presentation.dto.request.SignInRequest;
import com.spring.ideafestivalbackend.domain.user.presentation.dto.request.SignUpRequest;
import com.spring.ideafestivalbackend.domain.user.service.ChangePasswordService;
import com.spring.ideafestivalbackend.domain.user.service.RenewTokenService;
import com.spring.ideafestivalbackend.domain.user.service.SignInService;
import com.spring.ideafestivalbackend.domain.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

    private final SignInService signInService;
    private final SignUpService signUpService;
    private final RenewTokenService renewTokenService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@Valid @RequestBody SignUpRequest signupRequest) {
        signUpService.signUp(signupRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<SignInResponse> signIn(@Valid @RequestBody SignInRequest signinRequest) {
        SignInResponse data = signInService.signIn(signinRequest);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    @PatchMapping
    public ResponseEntity<NewTokenResponse> renewToken(@RequestHeader("RefreshToken")String refreshToken) {
        NewTokenResponse newTokenResponse = renewTokenService.tokenReissuance(refreshToken);
        return new ResponseEntity<>(newTokenResponse, HttpStatus.OK);
    }
}
