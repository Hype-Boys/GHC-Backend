package com.spring.ideafestivalbackend.global.security;

import com.spring.ideafestivalbackend.global.filter.JwtRequestFilter;
import com.spring.ideafestivalbackend.global.security.handler.CustomAccessDeniedHandler;
import com.spring.ideafestivalbackend.global.security.handler.CustomAuthenticationEntryPointHandler;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    private final JwtRequestFilter jwtRequestFilter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable();
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/WEBFLIX").permitAll()
                .antMatchers(HttpMethod.POST,
                        "/auth/signup",
                        "/auth",
                        "/user",
                        "/email"
                ).permitAll()
                .antMatchers(HttpMethod.PATCH,"/auth").permitAll()
                .antMatchers(HttpMethod.HEAD,
                        "email"
                ).permitAll()
                .antMatchers(HttpMethod.PATCH,"/user").authenticated()
                .anyRequest().authenticated();
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
