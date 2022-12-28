package com.spring.ideafestivalbackend.global.security.auth;

import com.spring.ideafestivalbackend.domain.user.exception.UserNotFoundException;
import com.spring.ideafestivalbackend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public UserDetails loadUserByUsername(String email){
        return userRepository.findUserByEmail(email)
                .map(AuthDetails::new)
                .orElseThrow(()->new UserNotFoundException("유저를 찾을 수 없습니다."));
    }
}
