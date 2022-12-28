package com.spring.ideafestivalbackend.domain.user.repository;

import com.spring.ideafestivalbackend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByEmail(String email);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Boolean existsByEmail(String email);
}
