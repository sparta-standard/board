package io.sparta.board.controller;

import io.sparta.board.dto.PostCreateRequestDto;
import io.sparta.board.dto.PostCreateResponseDto;
import io.sparta.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostCreateResponseDto> createPost(@RequestBody PostCreateRequestDto requestDto){
        return ResponseEntity.ok(postService.createPost(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostCreateResponseDto> getPost(@PathVariable UUID id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @GetMapping
    private ResponseEntity <List<PostCreateResponseDto>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

}
