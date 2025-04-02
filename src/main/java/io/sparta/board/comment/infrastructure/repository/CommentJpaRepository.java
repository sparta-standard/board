package io.sparta.board.comment.infrastructure.repository;

import io.sparta.board.comment.domain.entity.Comment;
import io.sparta.board.post.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentJpaRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findByPost(Post post);
}