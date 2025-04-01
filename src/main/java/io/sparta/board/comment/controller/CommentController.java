package io.sparta.board.comment.controller;

import io.sparta.board.comment.dto.CommentRequestDto;
import io.sparta.board.comment.dto.CommentResponseDto;
import io.sparta.board.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    // 댓글 등록
    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(
            @PathVariable UUID postId,
            @RequestBody CommentRequestDto requestDto) {

        CommentResponseDto responseDto = commentService.createComment(postId, requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

}
