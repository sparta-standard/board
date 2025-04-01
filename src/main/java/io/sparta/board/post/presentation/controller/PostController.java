package io.sparta.board.post.presentation.controller;

import io.sparta.board.post.application.dto.request.PostCreateRequestDto;
import io.sparta.board.post.application.dto.request.PostUpdateRequestDto;
import io.sparta.board.post.application.dto.response.PostUpdateResponseDto;
import io.sparta.board.post.application.dto.response.PostCreateResponseDto;
import io.sparta.board.post.application.dto.response.PostSearchResponseDto;
import io.sparta.board.post.application.service.PostService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<PostCreateResponseDto> createPost(
        @RequestBody PostCreateRequestDto requestDto
    ) {
        PostCreateResponseDto responseDto = postService.createPost(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostSearchResponseDto> searchPostFromId(
        @PathVariable(name = "postId") UUID postId
    ) {
        PostSearchResponseDto responseDto = postService.searchPost(postId);
        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping("/posts/{postId}")
    public ResponseEntity<PostUpdateResponseDto> updatePost(
        @PathVariable(name = "postId") UUID postId,
        @RequestBody PostUpdateRequestDto requestDto
    ) {
        PostUpdateResponseDto responseDto = postService.updatePost(postId, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<String> deletePost(
        @PathVariable(name = "postId") UUID postId
    ) {
        postService.deletePost(postId);
        return ResponseEntity.ok("삭제 완료");
    }
}
