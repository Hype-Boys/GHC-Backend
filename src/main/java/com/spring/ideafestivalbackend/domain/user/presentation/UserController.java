package com.spring.ideafestivalbackend.domain.user.presentation;


import com.spring.ideafestivalbackend.domain.user.service.ChangePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final ChangePasswordService changePasswordService;
}
