package io.sparta.board.board.domain.repository;

import io.sparta.board.board.domain.entity.Board;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, UUID> {

}
