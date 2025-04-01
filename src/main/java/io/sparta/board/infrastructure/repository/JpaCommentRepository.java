package io.sparta.board.infrastructure.repository;

import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCommentRepository extends JpaRepository<Comment, UUID> {

    Page<Comment> findAllByPost(Post post, Pageable pageable);
}
