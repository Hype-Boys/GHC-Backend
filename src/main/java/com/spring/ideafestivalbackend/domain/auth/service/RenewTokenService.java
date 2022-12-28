package com.spring.ideafestivalbackend.domain.auth.service;

import com.spring.ideafestivalbackend.domain.auth.entity.RefreshToken;
import com.spring.ideafestivalbackend.domain.auth.exception.RefreshTokenNotFoundException;
import com.spring.ideafestivalbackend.domain.auth.presentation.dto.response.NewTokenResponse;
import com.spring.ideafestivalbackend.domain.auth.repository.RefreshTokenRepository;
import com.spring.ideafestivalbackend.global.exception.TokenNotValidException;
import com.spring.ideafestivalbackend.global.security.jwt.TokenProvider;
import com.spring.ideafestivalbackend.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class RenewTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final TokenProvider tokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional(rollbackFor = Exception.class)
    public NewTokenResponse tokenReissuance(String reqToken) {
        String email = tokenProvider.getUserEmail(reqToken, jwtProperties.getRefreshSecret());
        RefreshToken token = refreshTokenRepository.findById(email)
                .orElseThrow(() -> new RefreshTokenNotFoundException("리프레쉬 토큰이 존재하지 없습니다."));
        if(!token.getToken().equals(reqToken)) {
            throw new TokenNotValidException("토큰이 유효하지 않습니다");
        }
        String accessToken = tokenProvider.generatedAccessToken(email);
        String refreshToken = tokenProvider.generatedRefreshToken(email);
        ZonedDateTime expiredAt = tokenProvider.getExpiredAtToken(accessToken, jwtProperties.getAccessSecret());
        token.exchangeRefreshToken(refreshToken);
        refreshTokenRepository.save(token);
        return NewTokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(expiredAt)
                .build();
    }
}
