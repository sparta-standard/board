package io.sparta.board.domain.repository;

import io.sparta.board.domain.model.Post;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepository {

    void save(Post post);

    Optional<Post> findById(UUID postId);
}
