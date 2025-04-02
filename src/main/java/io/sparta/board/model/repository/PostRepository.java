package io.sparta.board.model.repository;

import io.sparta.board.model.entity.Post;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(UUID id);

}
