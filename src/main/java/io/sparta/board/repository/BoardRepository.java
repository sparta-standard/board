package io.sparta.board.repository;

import io.sparta.board.repository.entity.Board;

import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.UUID;

@Repository
public interface BoardRepository extends JpaRepository<Board, UUID> {

    Board findByTitle(String title);

    @NonNull
    Page<Board> findAll(@NonNull Pageable pageable);
}
