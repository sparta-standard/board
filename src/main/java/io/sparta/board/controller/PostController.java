package io.sparta.board.controller;

import io.sparta.board.dto.request.PostCreateRequestDto;
import io.sparta.board.dto.response.PostResponseDto;
import io.sparta.board.dto.request.PostUpdateRequestDto;
import io.sparta.board.service.PostService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostCreateRequestDto requestDto){
        return ResponseEntity.ok(postService.createPost(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable UUID id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @GetMapping
    private ResponseEntity <List<PostResponseDto>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePost(@PathVariable UUID id,
                                                      @RequestBody PostUpdateRequestDto requestDto){
        return ResponseEntity.ok(postService.updatePost(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable UUID id){
        postService.deletePost(id);
        return ResponseEntity.ok("해당 게시물이 삭제되었습니다.");
    }
}
