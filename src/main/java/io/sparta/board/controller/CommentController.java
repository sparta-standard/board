package io.sparta.board.controller;

import io.sparta.board.dto.comment.CommentRequestDto;
import io.sparta.board.dto.comment.CommentResponseDto;
import io.sparta.board.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 작성
    @PostMapping("/{postId}/comments")
    public CommentResponseDto addComment(@PathVariable UUID postId, @RequestBody @Valid CommentRequestDto requestDto) {
        return commentService.addComment(postId, requestDto);
    }

    // 수정
    @PutMapping("/{postId}/comments/{commentId}")
    public CommentResponseDto updateComment(
            @PathVariable UUID postId,
            @PathVariable UUID commentId,
            @RequestBody @Valid CommentRequestDto requestDto) {
        return commentService.updateComment(postId, commentId, requestDto);
    }

    // 삭제
    @DeleteMapping("/{postId}/comments/{commentId}")
    public UUID deleteComment(
            @PathVariable UUID postId,
            @PathVariable UUID commentId) {
        return commentService.deleteComment(postId, commentId);
    }
}
