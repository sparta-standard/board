package io.sparta.board.post.domain.repository;

import io.sparta.board.post.domain.entity.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(UUID postId);
    List<Post> findAll();
}