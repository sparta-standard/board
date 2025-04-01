package io.sparta.board.model.post.repository;

import io.sparta.board.model.post.entity.Post;

import java.util.Optional;
import java.util.UUID;

public interface PostRepository {
    Post save(Post post);

    Optional<Post> findById(UUID id);

    Boolean existsByTitle(String title);
}
