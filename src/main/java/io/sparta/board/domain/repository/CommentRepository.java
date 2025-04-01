package io.sparta.board.domain.repository;

import io.sparta.board.domain.entity.Comment;

public interface CommentRepository {

    Comment save(Comment comment);
}
