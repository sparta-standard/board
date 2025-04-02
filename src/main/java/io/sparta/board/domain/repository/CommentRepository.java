package io.sparta.board.domain.repository;

import io.sparta.board.domain.entity.Comment;

import java.util.UUID;

public interface CommentRepository {

    Comment save(Comment comment);

    Comment findById(UUID id);
}
