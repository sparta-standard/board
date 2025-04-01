package io.sparta.board.board.infrastructure.repository;

import io.sparta.board.board.domain.repository.BoardRepository;
import io.sparta.board.board.infrastructure.jpa.BoardJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {

    private final BoardJpaRepository boardJpaRepository;

}
