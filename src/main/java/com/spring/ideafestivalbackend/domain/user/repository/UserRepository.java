package com.spring.ideafestivalbackend.GHC.domain.user.repository;
import com.spring.ideafestivalbackend.GHC.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
