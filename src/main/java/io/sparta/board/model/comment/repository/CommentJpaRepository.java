package io.sparta.board.model.comment.repository;

import io.sparta.board.model.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Repository
public interface CommentJpaRepository extends JpaRepository<Comment, UUID> {
    Optional<Comment> findByIdAndDeletedIsFalse(UUID id);

    List<Comment> findByPostIdAndDeletedIsFalse(UUID id);
}
