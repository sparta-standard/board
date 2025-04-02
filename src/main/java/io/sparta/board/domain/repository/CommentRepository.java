package io.sparta.board.domain.repository;

import io.sparta.board.domain.entity.Comment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

  boolean existsByIdAndPostId(UUID id, UUID postId);
}
