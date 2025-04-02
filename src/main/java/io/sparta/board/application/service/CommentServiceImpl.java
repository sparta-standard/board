package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.CommentCreateRequestDto;
import io.sparta.board.application.dto.response.CommentCreateResponseDto;
import io.sparta.board.domain.entity.Comment;
import io.sparta.board.domain.entity.Post;
import io.sparta.board.domain.repository.CommentRepository;
import io.sparta.board.domain.repository.PostRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

  private final CommentRepository commentRepository;
  private final PostRepository postRepository;

  @Override
  @Transactional
  public CommentCreateResponseDto createComment(UUID postId, CommentCreateRequestDto requestDto) {
    log.info("댓글 등록 서비스 연결 완료 - id: {} , content: {}", postId, requestDto.getContent());

    postRepository.findById(postId)
        .orElseThrow(() -> new IllegalArgumentException("해당하는 게시물이 없습니다."));

    Comment comment = commentRepository.save(
        Comment.builder()
            .postId(postId)
            .content(requestDto.getContent())
            .deleted(false)
            .build()
    );

    return new CommentCreateResponseDto(comment);
  }
}
