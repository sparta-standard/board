package io.sparta.board.infrastructure.repository;

import io.sparta.board.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaPostRepository extends JpaRepository<Post, UUID> {
}
