package io.sparta.board.domain.repository;

import io.sparta.board.domain.entity.Post;

public interface PostRepository {

    Post save(Post post);
}
