package io.sparta.board.repository;

import io.sparta.board.repository.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID>{
    List<Comment> findByBoardId(UUID id);
}
