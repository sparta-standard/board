package io.sparta.board.post.domain.repository;

import io.sparta.board.post.domain.entity.Post;

public interface PostRepository {
    Post save(Post post);
}