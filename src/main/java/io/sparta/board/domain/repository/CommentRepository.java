package io.sparta.board.domain.repository;

import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepository {
    Page<Comment> findAllByPost(Post post, Pageable pageable);

}
