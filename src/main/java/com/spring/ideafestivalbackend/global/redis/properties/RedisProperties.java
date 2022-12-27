package com.spring.ideafestivalbackend.global.redis.properties;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
    private final String host;
    private final Integer port;
}
