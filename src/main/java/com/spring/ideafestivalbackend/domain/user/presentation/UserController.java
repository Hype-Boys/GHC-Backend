package com.spring.ideafestivalbackend.domain.user.presentation;


import com.spring.ideafestivalbackend.domain.user.presentation.dto.request.ChangePasswordRequest;
import com.spring.ideafestivalbackend.domain.user.service.ChangePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final ChangePasswordService changePasswordService;

    @PatchMapping
    public ResponseEntity<Void> changePassword(@RequestBody @Valid ChangePasswordRequest changePasswordRequest){
        changePasswordService.execute(changePasswordRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
