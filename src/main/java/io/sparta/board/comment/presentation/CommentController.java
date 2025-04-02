package io.sparta.board.comment.presentation;

import io.sparta.board.comment.application.dto.request.CommentRequestDto;
import io.sparta.board.comment.application.dto.response.CommentResponseDto;
import io.sparta.board.comment.application.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{postId}")
    public ResponseEntity<CommentResponseDto> createPost(
            @PathVariable UUID postId,
            @RequestBody @Valid CommentRequestDto commentRequestDto
    ) {
        CommentResponseDto commentResponseDto = commentService.createComment(postId, commentRequestDto);
        return ResponseEntity.ok(commentResponseDto);
    }
}