package io.sparta.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.sparta.board.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
