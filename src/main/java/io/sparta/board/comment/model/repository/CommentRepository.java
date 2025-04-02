package io.sparta.board.comment.model.repository;

import io.sparta.board.comment.model.entity.Comment;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Pageable;

public interface CommentRepository {

    Comment save(Comment comment);

    Optional<Comment> findById(UUID commentId);

    List<Comment> findByPostIdAndDeletedFalse(UUID postId, Pageable pageable);

    List<Comment> findByPostIdAndDeletedFalse(UUID postId);
}
