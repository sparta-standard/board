package io.sparta.board.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.sparta.board.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	Optional<Comment> findByCommentIdAndDeletedFalse(UUID commentId);
}
