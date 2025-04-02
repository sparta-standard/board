package io.sparta.board.post.presentation;

import io.sparta.board.post.application.dto.request.PostRequestDto;
import io.sparta.board.post.application.dto.response.PostListResponseDto;
import io.sparta.board.post.application.dto.response.PostResponseDto;
import io.sparta.board.post.application.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto requestDto) {
        PostResponseDto response = postService.createPost(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<PostListResponseDto> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable UUID postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostResponseDto> updatePost(
            @PathVariable UUID postId,
            @RequestBody PostRequestDto requestDto) {
        return ResponseEntity.ok(postService.updatePost(postId, requestDto));
    }
}