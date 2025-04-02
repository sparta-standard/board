package io.sparta.board.presentation.controller;

import io.sparta.board.application.service.PostService;
import io.sparta.board.presentation.dto.request.CreatePostRequestDto;
import io.sparta.board.presentation.dto.request.UpdatePostRequestDto;
import io.sparta.board.presentation.dto.response.CreatePostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    //게시글 작성
    @PostMapping
    public ResponseEntity<CreatePostResponseDto> createPost(@RequestBody CreatePostRequestDto requestDto) {
        CreatePostResponseDto responseDto = postService.createPost(requestDto);

        return ResponseEntity.ok(responseDto);
    }

    //게시글 수정
    @PatchMapping
    public void updatePost(@RequestBody UpdatePostRequestDto requestDto) {

    }


    //[ ] 게시글 작성
  // 게시글 제목, 내용필수
  //* [ ] dto 작성
  // [ ] 컨트롤러 작성
    // [ ] 서비스, jpa 메서드 작성
//[ ] 게시글 수정
  // 제목, 내용만 수정가능
  // [ ] dto 작성
  // [ ] 엔티티에 update 메서드 추가
  // [ ] 컨트롤러 작성
  // [ ] 서비스 작성

}
