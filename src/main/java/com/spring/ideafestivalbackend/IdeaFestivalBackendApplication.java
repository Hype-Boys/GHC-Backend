package com.spring.ideafestivalbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@EnableCaching
@SpringBootApplication
@ConfigurationPropertiesScan
public class IdeaFestivalBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(IdeaFestivalBackendApplication.class, args);
    }

}
