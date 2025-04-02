package io.sparta.board.infrastructure.repository.jpa;

import io.sparta.board.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentJpaRepository extends JpaRepository<Comment, UUID> {
}
