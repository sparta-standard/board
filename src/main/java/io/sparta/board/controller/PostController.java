package io.sparta.board.controller;

import io.sparta.board.dto.ApiResponse;
import io.sparta.board.dto.post.PostDetailResponseDto;
import io.sparta.board.dto.post.PostRequestDto;
import io.sparta.board.dto.post.PostResponseDto;
import io.sparta.board.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<PostResponseDto>> createPost(@RequestBody @Valid PostRequestDto requestDto) {
        PostResponseDto response = postService.createPost(requestDto);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 수정
    @PutMapping("/posts/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> updatePost(@PathVariable UUID id, @RequestBody @Valid PostRequestDto requestDto) {
        PostResponseDto response = postService.updatePost(id, requestDto);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 삭제
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<ApiResponse<UUID>> deletePost(@PathVariable UUID id) {
        UUID deletedId = postService.deletePost(id);
        return ResponseEntity.ok(ApiResponse.success(deletedId));
    }

    // 전체 조회
    @GetMapping("/posts")
    public ResponseEntity<ApiResponse<List<PostResponseDto>>> getAllPosts() {
        List<PostResponseDto> response = postService.getAllPosts();
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 단건 조회
    @GetMapping("/posts/{id}")
    public ResponseEntity<ApiResponse<PostDetailResponseDto>> getPost(@PathVariable UUID id) {
        PostDetailResponseDto response = postService.getPost(id);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
