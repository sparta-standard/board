package io.sparta.board.model.repository;

import io.sparta.board.model.entity.Comment;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentRepository {

    Comment save(Comment comment);

    Optional<Comment> findById(UUID commentId);

    List<Comment> findByPostId(UUID postId);
}
