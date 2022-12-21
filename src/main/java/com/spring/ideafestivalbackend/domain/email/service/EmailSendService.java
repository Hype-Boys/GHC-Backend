package com.spring.ideafestivalbackend.domain.email.service;

import com.spring.ideafestivalbackend.domain.email.entity.EmailEntity;
import com.spring.ideafestivalbackend.domain.email.presentation.dto.EmailDto;
import com.spring.ideafestivalbackend.domain.email.repository.EmailRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Random;

@Service
@RequiredArgsConstructor
@EnableAsync
public class EmailSendService {
    private final JavaMailSender emailSender;

    private final EmailRepository emailRepository;

    @Async
    public void sendMail(EmailDto emailDto){
        Random random = new Random();
        String authCode = String.valueOf(random.nextInt(9999)+1111);
        sendAuthCode(emailDto.getEmail(),authCode);
    }

    private void sendAuthCode(String email, String authCode){
        String title = "회원가입 이메일 인증번호";
        String text = "회원가입 인증번호는 " + authCode + "입니다. 돌아가셔서 입력해주세요";
        EmailEntity emailEntity = emailRepository.findById(email)
                .orElse(EmailEntity.builder()
                        .verification(false)
                        .randomValue(authCode)
                        .email(email)
                        .build());
    }
}
