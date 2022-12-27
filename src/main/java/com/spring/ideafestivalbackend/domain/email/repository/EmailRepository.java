package com.spring.ideafestivalbackend.domain.email.repository;

import com.spring.ideafestivalbackend.domain.email.entity.EmailEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<EmailEntity, String> {
}
