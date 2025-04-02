package io.sparta.board.comment.domain.repository;

import io.sparta.board.comment.domain.entity.Comment;
import io.sparta.board.post.domain.entity.Post;

import java.util.List;

public interface CommentRepository {
    Comment save(Comment comment);
    List<Comment> findByPost(Post post);
}