package io.sparta.board.model.repository;

import io.sparta.board.model.entity.Comment;
import io.sparta.board.model.entity.Post;

public interface CommentRepository {
    Comment save(Comment comment);
}
