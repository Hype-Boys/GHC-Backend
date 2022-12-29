package com.spring.ideafestivalbackend.domain.email.service;


import com.spring.ideafestivalbackend.domain.email.entity.EmailEntity;
import com.spring.ideafestivalbackend.domain.email.exception.MailAuthCodeExpiredException;
import com.spring.ideafestivalbackend.domain.email.exception.NotMatchAuthCodeException;
import com.spring.ideafestivalbackend.domain.email.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailVerifyService {
    private final EmailRepository emailVerifyRepository;

    public void verificationMail(String email, String verifyCode){
        EmailEntity emailVerifyEntity = emailVerifyRepository.findById(email)
                .orElseThrow(()-> new MailAuthCodeExpiredException("인증코드가 만료되었습니다."));
        String code = emailVerifyEntity.getRandomValue();
        if(!emailVerifyEntity.getRandomValue().equals(verifyCode)){
            throw new NotMatchAuthCodeException("인증코드가 일치하지 않습니다.");
        }
        emailVerifyEntity.updateVerification(true);
        emailVerifyRepository.save(emailVerifyEntity);
    }

}