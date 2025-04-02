package io.sparta.board.repository;

import io.sparta.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findByDeletedFalse();

    Optional<Post> findByIdAndDeletedFalse(UUID id);

}
