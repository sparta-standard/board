package io.sparta.board.comment.domain.repository;

import io.sparta.board.comment.domain.entity.Comment;

public interface CommentRepository {
    Comment save(Comment comment);
}