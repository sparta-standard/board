package io.sparta.board.presentation.controller;

import io.sparta.board.application.dto.request.PostCreateRequestDto;
import io.sparta.board.application.dto.request.PostUpdateRequestDto;
import io.sparta.board.application.dto.response.PostCreateResponseDto;
import io.sparta.board.application.dto.response.PostDetailResponseDto;
import io.sparta.board.application.dto.response.PostUpdateResponseDto;
import io.sparta.board.application.service.PostService;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  // 게시판 생성
  @PostMapping
  public PostCreateResponseDto createPost(
      @Valid @RequestBody PostCreateRequestDto requestDto) {
    log.info("게시판 생성 컨트롤러 연결 완료");
    PostCreateResponseDto responseDto = postService.createPost(requestDto);
    return responseDto;
  }

  // 게시판 수정
  @PutMapping("/{id}")
  public PostUpdateResponseDto updatePost(
      @PathVariable UUID id,
      @Valid @RequestBody PostUpdateRequestDto requestDto
  ) {
    log.info("게시판 수정 컨트롤러 연결 완료 - id : {}", id);
    return new PostUpdateResponseDto();
  }

  // 게시판 삭제
  @DeleteMapping("/{id}")
  public void deletePost(@PathVariable UUID id) {
    log.info("게시판 삭제 컨트롤러 연결 완료 - id : {}", id);
  }

  // 게시판 단건 조회
  @GetMapping("/{id}")
  public PostDetailResponseDto getPost(@PathVariable UUID id) {
    log.info("게시판 단건 조회 컨트롤러 연결 완료 - id : {}", id);
    return new PostDetailResponseDto();
  }
}
