package io.sparta.board.domain.repository;

import io.sparta.board.domain.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    Optional<Post> findByIdAndDeletedIsFalse(UUID id);

    Page<Post> findAllByDeletedIsFalse(PageRequest pageRequest);
}
