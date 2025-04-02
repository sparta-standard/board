package io.sparta.board.repository;

import io.sparta.board.repository.entity.Board;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.UUID;

@Repository
public interface BoardRepository extends JpaRepository<Board, UUID> {

    <Optional> Board findByTitle(String title);

    Page<Board> findAll(Pageable pageable);
}
