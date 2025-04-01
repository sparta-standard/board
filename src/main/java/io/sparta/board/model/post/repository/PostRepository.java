package io.sparta.board.model.post.repository;

import io.sparta.board.model.post.entity.Post;

public interface PostRepository {
    Post save(Post post);
}
