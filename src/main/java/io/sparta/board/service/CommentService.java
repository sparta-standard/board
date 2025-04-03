package io.sparta.board.service;


import io.sparta.board.dto.CommentRequestDto;
import io.sparta.board.entity.Comment;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.CommentRepository;
import io.sparta.board.repository.PostRepository;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;
  private final PostRepository postRepository;

  @Transactional
  public UUID createComment(UUID postId, CommentRequestDto requestDto) {
    Post post = postRepository.findByIdAndDeletedFalse(postId)
        .orElseThrow(() -> new IllegalArgumentException("댓글을 달 수 잇는 게시글이 존재하지 않습니다."));

    Comment comment = Comment.builder()
        .post(post)
        .content(requestDto.getContent())
        .build();

    commentRepository.save(comment);
    return comment.getId();
  }


@Transactional
  public void updateComment(UUID commentId, CommentRequestDto requestDto){
    Comment comment = commentRepository.findById(commentId)
        .orElseThrow(()-> new IllegalArgumentException("댓글이 존재하지 않습니다."));

    if (comment.isDeleted()) {
      throw new IllegalArgumentException("이미 삭제된 댓글입니다.");
    }

    comment.update(requestDto.getContent());
}

@Transactional
  public void deleteComment(UUID commentId){
    Comment comment = commentRepository.findById(commentId)
        .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));

    if (comment.isDeleted()) {
      throw new IllegalStateException("이미 삭제된 댓글입니다.");
    }

    comment.softDelete();
}
}
