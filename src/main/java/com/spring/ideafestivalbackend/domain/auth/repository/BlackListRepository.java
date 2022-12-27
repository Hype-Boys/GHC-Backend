package com.spring.ideafestivalbackend.domain.auth.repository;

import com.spring.ideafestivalbackend.domain.auth.entity.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListRepository extends JpaRepository<BlackList, String> {
}
