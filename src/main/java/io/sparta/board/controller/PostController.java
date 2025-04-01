package io.sparta.board.controller;

import io.sparta.board.dto.PostRequestDto;
import io.sparta.board.dto.PostResponseDto;
import io.sparta.board.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 작성
    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    // 수정
    @PutMapping("/posts/{id}")
    public PostResponseDto updatePost(@PathVariable UUID id, @RequestBody PostRequestDto requestDto) {
        return postService.updatePost(id, requestDto);
    }

    // 삭제
    @DeleteMapping("/posts/{id}")
    public UUID deletePost(@PathVariable UUID id) {
        return postService.deletePost(id);
    }
}
