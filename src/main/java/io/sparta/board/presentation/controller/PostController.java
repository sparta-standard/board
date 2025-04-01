package io.sparta.board.presentation.controller;

import io.sparta.board.application.facade.PostFacade;
import io.sparta.board.presentation.dto.PostCreateRequestDto;
import io.sparta.board.presentation.dto.PostResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
}
