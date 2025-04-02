package io.sparta.board.presentation.controller;

import io.sparta.board.application.service.PostService;
import io.sparta.board.presentation.dto.request.CreatePostRequestDto;
import io.sparta.board.presentation.dto.request.UpdatePostRequestDto;
import io.sparta.board.presentation.dto.response.CreatePostResponseDto;
import io.sparta.board.presentation.dto.response.UpdatePostResponseDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @PatchMapping("/{postId}")
    public ResponseEntity<UpdatePostResponseDto> updatePost(@PathVariable UUID postId, @RequestBody UpdatePostRequestDto requestDto) {
        UpdatePostResponseDto responseDto = postService.updatePost(postId, requestDto);
        return ResponseEntity.ok(responseDto);
    }

}
