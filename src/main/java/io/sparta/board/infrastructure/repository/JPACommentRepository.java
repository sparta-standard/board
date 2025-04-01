package io.sparta.board.infrastructure.repository;

import io.sparta.board.model.entity.Comment;
import io.sparta.board.model.repository.CommentRepository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPACommentRepository extends JpaRepository<Comment, UUID>, CommentRepository {
}
