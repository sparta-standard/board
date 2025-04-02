package io.sparta.board.comment.repository;

import io.sparta.board.comment.model.Comment;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {

    List<Comment> findAllByPostId(UUID postId);

    Page<Comment> findAllByPostIdAndIsDeletedFalse(UUID postId, Pageable pageable);

    Optional<Comment> findByIdAndIsDeletedFalse(UUID commentId);
}
