package io.sparta.board.comment.repository;

import io.sparta.board.comment.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID>  {

    Page<Comment> findByPostIdAndDeletedFalse(UUID postId, Pageable pageable);

    Optional<Comment> findByIdAndDeletedFalse(UUID id);

    void deleteAllByPostId(UUID postId);
}
