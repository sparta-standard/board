package io.sparta.board.controller;

import io.sparta.board.dto.request.PostCreateRequestDto;
import io.sparta.board.dto.request.PostUpdateRequestDto;
import io.sparta.board.dto.response.PostDetailResponseDto;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.PostRepository;
import io.sparta.board.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDetailResponseDto> createPost(@RequestBody PostCreateRequestDto dto) {
        return ResponseEntity.ok(postService.createPost(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDetailResponseDto> updatePost(
            @PathVariable UUID id,
            @RequestBody PostUpdateRequestDto dto
    ) {
        return ResponseEntity.ok(postService.updatePost(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDetailResponseDto> getPost(@PathVariable UUID id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

    @GetMapping
    public ResponseEntity<List<PostDetailResponseDto>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}