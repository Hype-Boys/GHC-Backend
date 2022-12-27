package com.spring.ideafestivalbackend.domain.user.service;

import com.spring.ideafestivalbackend.domain.auth.exception.NotVerifyEmailException;
import com.spring.ideafestivalbackend.domain.email.entity.EmailEntity;
import com.spring.ideafestivalbackend.domain.email.repository.EmailRepository;
import com.spring.ideafestivalbackend.domain.user.entity.User;
import com.spring.ideafestivalbackend.domain.user.presentation.dto.request.ChangePasswordRequest;
import com.spring.ideafestivalbackend.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ChangePasswordService {
    private final UserUtil userUtil;
    private final PasswordEncoder passwordEncoder;
    private final EmailRepository emailRepository;

    @Transactional(rollbackFor = {Exception.class})
    public void execute(ChangePasswordRequest changePasswordRequest){
        User user = userUtil.currentUser();
        if(validateAuthentication(user.getEmail())){
            user.updatePassword(passwordEncoder.encode(changePasswordRequest.getPassword()));
        }
    }

    private Boolean validateAuthentication(String email){
        EmailEntity emailAuth = emailRepository.findById(email).orElseThrow(()->new NotVerifyEmailException("이메일이 인증되지 않았습니다"));
        if (!emailAuth.getVerification()){
            throw new NotVerifyEmailException("이메일이 인증되지 않았습니다.");
        }
        return true;
    }


}
