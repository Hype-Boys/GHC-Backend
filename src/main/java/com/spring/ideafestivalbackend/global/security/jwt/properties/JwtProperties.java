package com.spring.ideafestivalbackend.global.security.jwt.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@AllArgsConstructor
@ConfigurationProperties(prefix = "spring.jwt")
public class JwtProperties {
    private final String accessSecret;
    private final String refreshSecret;
}
