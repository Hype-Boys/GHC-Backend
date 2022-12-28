package com.spring.ideafestivalbackend.domain.board.repository;



import com.spring.ideafestivalbackend.domain.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    Optional<BoardEntity> findById(Long id);
}
