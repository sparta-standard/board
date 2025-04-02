package io.sparta.board.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import io.sparta.board.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	Optional<Comment> findByCommentIdAndDeletedFalse(UUID commentId);
	Page<Comment> findByPost_PostIdAndDeletedFalse(UUID postId, Pageable pageable);
}
