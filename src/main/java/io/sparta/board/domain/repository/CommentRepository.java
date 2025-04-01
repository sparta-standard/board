package io.sparta.board.domain.repository;

import io.sparta.board.domain.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository {

    void save(Comment comment);
}
