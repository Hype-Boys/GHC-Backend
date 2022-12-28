package com.spring.ideafestivalbackend.domain.user.service;

import com.spring.ideafestivalbackend.domain.user.exception.EmailAlreadyExistException;
import com.spring.ideafestivalbackend.domain.user.presentation.dto.request.SignUpRequest;
import com.spring.ideafestivalbackend.domain.user.entity.User;
import com.spring.ideafestivalbackend.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional(rollbackFor = Exception.class)
    public void signUp(SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new EmailAlreadyExistException("이메일이 중복되었습니다.");
        }
        User user = User.builder()
                .email(signUpRequest.getEmail())
                .name(signUpRequest.getName())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .build();
        userRepository.save(user);
    }

}
