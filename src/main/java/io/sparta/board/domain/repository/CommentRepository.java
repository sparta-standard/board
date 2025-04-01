package io.sparta.board.domain.repository;

import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository {

    void save(Comment comment);

    Page<Comment> findAllByPost(Post post, Pageable pageable);
}
