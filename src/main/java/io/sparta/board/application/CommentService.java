package io.sparta.board.application;

import io.sparta.board.domain.Comment;
import io.sparta.board.infrastructure.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

  private final CommentRepository commentRepository;

  public void save(Comment comment) {

    commentRepository.save(comment);
  }
}
