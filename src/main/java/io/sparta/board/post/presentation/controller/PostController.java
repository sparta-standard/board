package io.sparta.board.post.presentation.controller;

import io.sparta.board.post.application.facade.PostFacade;
import io.sparta.board.post.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.post.presentation.dto.request.PostUpdateRequestDto;
import io.sparta.board.post.presentation.dto.response.PostResponseDto;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/api/posts")
public class PostController {

    private final PostFacade postFacade;

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(
        @Valid
        @RequestBody PostCreateRequestDto requestDto
    ) {
        return ResponseEntity.ok(postFacade.createPost(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPost(
        @PathVariable("id") UUID postId,
        Pageable pageable
    ) {
        return ResponseEntity.ok(postFacade.getPost(postId, pageable));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePost(
        @Valid
        @RequestBody PostUpdateRequestDto requestDto,
        @PathVariable("id") UUID postId
    ) {
        return ResponseEntity.ok(postFacade.updatePost(postId, requestDto));
    }

    @DeleteMapping("/{id}")
    public void deletePost(
        @PathVariable("id") UUID postId
    ) {
        postFacade.deletePost(postId);
    }
}
