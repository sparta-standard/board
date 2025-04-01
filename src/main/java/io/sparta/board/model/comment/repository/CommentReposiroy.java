package io.sparta.board.model.comment.repository;

import io.sparta.board.model.comment.entity.Comment;

import java.util.Optional;
import java.util.UUID;

public interface CommentReposiroy {
    Comment save(Comment comment);

    Optional<Comment> findByIdAndDeletedIsFalse(UUID id);
}
