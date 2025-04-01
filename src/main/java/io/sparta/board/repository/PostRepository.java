package io.sparta.board.repository;

import io.sparta.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByDeletedFalseOrderByCreatedAtDesc();
    Optional<Post> findByIdAndDeletedFalse(UUID id);
}
