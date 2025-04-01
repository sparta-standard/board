package io.sparta.board.domain.repository;

import io.sparta.board.domain.entity.Post;

import java.util.UUID;

public interface PostRepository {

    Post save(Post post);

    Post findByPostId(UUID id);
}
