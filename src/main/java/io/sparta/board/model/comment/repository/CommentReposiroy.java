package io.sparta.board.model.comment.repository;

import io.sparta.board.model.comment.entity.Comment;

public interface CommentReposiroy {
    Comment save(Comment comment);
}
