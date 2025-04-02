package io.sparta.board.controller;

import io.sparta.board.dto.post.PostDetailResponseDto;
import io.sparta.board.dto.post.PostRequestDto;
import io.sparta.board.dto.post.PostResponseDto;
import io.sparta.board.service.PostService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public PostResponseDto createPost(@RequestBody @Valid PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    // 수정
    @PutMapping("/posts/{id}")
    public PostResponseDto updatePost(@PathVariable UUID id, @RequestBody @Valid PostRequestDto requestDto) {
        return postService.updatePost(id, requestDto);
    }

    // 삭제
    @DeleteMapping("/posts/{id}")
    public UUID deletePost(@PathVariable UUID id) {
        return postService.deletePost(id);
    }

    // 전체 조회
    @GetMapping("/posts")
    public List<PostResponseDto> getAllPosts() {
        return postService.getAllPosts();
    }

    // 단건 조회
    @GetMapping("/posts/{id}")
    public PostDetailResponseDto getPost(@PathVariable UUID id) {
        return postService.getPost(id);
    }
}
