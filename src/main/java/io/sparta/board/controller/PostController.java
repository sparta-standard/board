package io.sparta.board.controller;

import io.sparta.board.dto.PostCreateRequestDto;
import io.sparta.board.dto.PostCreateResponseDto;
import io.sparta.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostCreateResponseDto> createPost(@RequestBody PostCreateRequestDto requestDto){
        return ResponseEntity.ok(postService.createPost(requestDto));
    }

}
