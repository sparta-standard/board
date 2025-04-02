package io.sparta.board.comment.infrastructure.repository;

import io.sparta.board.comment.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentJpaRepository extends JpaRepository<Comment, UUID> {
}