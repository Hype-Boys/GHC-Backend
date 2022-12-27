package com.spring.ideafestivalbackend.GHC.domain.user.service;

import com.spring.ideafestivalbackend.GHC.domain.user.presentation.dto.UserDto;
import com.spring.ideafestivalbackend.GHC.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(UserDto userDto){
        userRepository.save(userDto.UserEntity());
    }
}
