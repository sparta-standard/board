package io.sparta.board.post.repository;

import io.sparta.board.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID>  {

    Optional<Post> findByIdAndDeletedFalse(UUID id);
}
