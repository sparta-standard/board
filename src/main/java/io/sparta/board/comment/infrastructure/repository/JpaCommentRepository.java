package io.sparta.board.comment.infrastructure.repository;

import io.sparta.board.comment.model.entity.Comment;
import io.sparta.board.comment.model.repository.CommentRepository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepository extends JpaRepository<Comment, UUID>, CommentRepository {

}
