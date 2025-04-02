package io.sparta.board.application.usecase;

import io.sparta.board.model.entity.Comment;

public interface CommentService {

    Comment createComment(Comment comment);
}
