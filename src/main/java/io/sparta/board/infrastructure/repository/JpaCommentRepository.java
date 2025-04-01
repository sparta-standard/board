package io.sparta.board.infrastructure.repository;

import io.sparta.board.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface JpaCommentRepository extends JpaRepository<Comment, UUID> {
}
