package io.sparta.board.domain.comment.controller;

import io.sparta.board.domain.comment.dto.requeset.CommentCreateRequestDto;
import io.sparta.board.domain.comment.dto.response.CommentResponseDto;
import io.sparta.board.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentCotroller {

    private final CommentService commentService;

    @PostMapping("/{postId}")
    public ResponseEntity<CommentResponseDto> createComment(
            @RequestBody CommentCreateRequestDto request,
            @PathVariable UUID postId
    ){
        CommentResponseDto response = commentService.createComment(request, postId);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
