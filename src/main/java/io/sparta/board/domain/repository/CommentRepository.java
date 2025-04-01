package io.sparta.board.domain.repository;

import io.sparta.board.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

    List<Comment> findByPostIdAndDeletedIsFalse(UUID postId);

    Optional<Comment> findByIdAndDeletedIsFalse(UUID id);
}
