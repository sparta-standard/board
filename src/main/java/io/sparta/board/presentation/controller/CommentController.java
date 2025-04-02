package io.sparta.board.presentation.controller;

import io.sparta.board.application.dto.request.CommentCreateRequestDto;
import io.sparta.board.application.dto.request.CommentUpdateRequestDto;
import io.sparta.board.application.dto.response.CommentCreateResponseDto;
import io.sparta.board.application.dto.response.CommentUpdateResponseDto;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/posts")
public class CommentController {

  // 댓글 등록
  @PostMapping("/{postId}")
  public CommentCreateResponseDto createComment(@PathVariable UUID postId,
      @RequestBody CommentCreateRequestDto requestDto) {
    log.info("댓글 등록 컨트롤러 연결 완료");
    return new CommentCreateResponseDto();
  }

  // 댓글 수정
  @PutMapping("/{postId}/{id}")
  public CommentUpdateResponseDto updateComment(@PathVariable UUID postId,
      @PathVariable UUID id,
      @RequestBody CommentUpdateRequestDto requestDto) {
    log.info("댓글 수정 컨트롤러 연결 완료");
    return new CommentUpdateResponseDto();
  }

  // 댓글 삭제
  @DeleteMapping("/{postId}/{id}")
  public String deleteComment(@PathVariable UUID postId,
      @PathVariable UUID id) {
    log.info("댓글 삭제 컨트롤러 연결 완료");
    return "delete success!";
  }
}
