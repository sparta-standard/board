package io.sparta.board.model.repository;

import io.sparta.board.model.entity.Post;

public interface PostRepository {
    Post save(Post post);
}
