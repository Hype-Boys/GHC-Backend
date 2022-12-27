package com.spring.ideafestivalbackend.domain.auth.service;

import com.spring.ideafestivalbackend.domain.auth.entity.BlackList;
import com.spring.ideafestivalbackend.domain.auth.entity.RefreshToken;
import com.spring.ideafestivalbackend.domain.auth.exception.BlackListAlreadyExistException;
import com.spring.ideafestivalbackend.domain.auth.exception.RefreshTokenNotFoundException;
import com.spring.ideafestivalbackend.domain.auth.repository.BlackListRepository;
import com.spring.ideafestivalbackend.domain.auth.repository.RefreshTokenRepository;
import com.spring.ideafestivalbackend.domain.user.entity.User;
import com.spring.ideafestivalbackend.global.redis.properties.RedisProperties;
import com.spring.ideafestivalbackend.global.security.jwt.TokenProvider;
import com.spring.ideafestivalbackend.global.security.jwt.properties.JwtProperties;
import com.spring.ideafestivalbackend.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class LogoutService {
    private final RefreshTokenRepository refreshTokenRepository;

    private final BlackListRepository blackListRepository;

    private final TokenProvider tokenProvider;

    private final JwtProperties jwtProperties;

    private final RedisTemplate redisTemplate;

    private final UserUtil userUtil;

    @Transactional(rollbackFor = {Exception.class})
    public void execute(String accessToken){
        User user = userUtil.currentUser();
        RefreshToken refreshToken = refreshTokenRepository.findRefreshTokenByEmail(user.getEmail()).orElseThrow(()->new RefreshTokenNotFoundException("리프레시 토큰을 찾을 수 없습니다."));
        refreshTokenRepository.delete(refreshToken);
        saveBlackList(user.getEmail(),accessToken);
    }

    private void saveBlackList(String email, String accessToken){
        if(redisTemplate.opsForValue().get(accessToken)!=null){
            throw new BlackListAlreadyExistException("블랙리스트에 이미 등록되어있습니다.");
        }
        ZonedDateTime accessTokenExpire = tokenProvider.getExpiredAtToken(accessToken,jwtProperties.getAccessSecret());
        BlackList blackList = BlackList.builder()
                .email(email)
                .accessToken(accessToken)
                .timeToLive(accessTokenExpire)
                .build();
        blackListRepository.save(blackList);
    }
}
