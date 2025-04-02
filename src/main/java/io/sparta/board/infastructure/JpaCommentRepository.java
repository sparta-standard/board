package io.sparta.board.infastructure;

import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.repository.CommentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepository extends JpaRepository<Comment, Long>, CommentRepository {
}
