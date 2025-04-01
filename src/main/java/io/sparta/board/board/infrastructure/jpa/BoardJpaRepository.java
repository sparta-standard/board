package io.sparta.board.board.infrastructure.jpa;

import io.sparta.board.board.domain.entity.Board;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<Board, UUID> {

}
