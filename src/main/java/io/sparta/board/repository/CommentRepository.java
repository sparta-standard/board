package io.sparta.board.repository;

import io.sparta.board.entity.Comment;
import io.sparta.board.entity.Post;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

  // 해당 게시글에 달린 삭제되지 않은 댓글 목록
  List<Comment> findByPostAndDeletedFalse(Post post);

}
