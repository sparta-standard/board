package io.sparta.board.comment.domain.repository;

import io.sparta.board.comment.domain.entity.Comment;
import io.sparta.board.post.domain.entity.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentRepository {
    Comment save(Comment comment);
    List<Comment> findByPost(Post post);
    Optional<Comment> findById(UUID commentId);
}