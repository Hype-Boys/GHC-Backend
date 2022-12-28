package com.spring.ideafestivalbackend.domain.auth.service;

import com.spring.ideafestivalbackend.domain.auth.exception.EmailAlreadyExistException;
import com.spring.ideafestivalbackend.domain.auth.exception.NotVerifyEmailException;
import com.spring.ideafestivalbackend.domain.auth.presentation.dto.request.UserSignupRequest;
import com.spring.ideafestivalbackend.domain.email.entity.EmailEntity;
import com.spring.ideafestivalbackend.domain.email.repository.EmailRepository;
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
    private final EmailRepository emailRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    public void singUp(UserSignupRequest request) {
        if(userRepository.existByEmail(request.getEmail())) {
            throw new EmailAlreadyExistException("이메일이 이미 존재 합니다.");
        }
        EmailEntity emailEntity = emailRepository.findById(request.getEmail())
                .orElseThrow(() -> new NotVerifyEmailException("이메일이 인증되지 않았습니다."));

       if(!emailEntity.getAuthentication()){
           throw new NotVerifyEmailException("이메일이 인증되지 않았습니다");
       }
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
    }

}
