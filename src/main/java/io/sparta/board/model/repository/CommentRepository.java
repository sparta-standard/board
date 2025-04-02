package io.sparta.board.model.repository;

import io.sparta.board.model.entity.Comment;

public interface CommentRepository {
    Comment save(Comment comment);
}
