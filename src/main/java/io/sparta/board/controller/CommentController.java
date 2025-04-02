package io.sparta.board.controller;

import io.sparta.board.dto.ApiResponse;
import io.sparta.board.dto.comment.CommentRequestDto;
import io.sparta.board.dto.comment.CommentResponseDto;
import io.sparta.board.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<CommentResponseDto>> addComment(@PathVariable UUID postId, @RequestBody @Valid CommentRequestDto requestDto) {
        CommentResponseDto response = commentService.addComment(postId, requestDto);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 수정
    @PutMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<ApiResponse<CommentResponseDto>> updateComment(
            @PathVariable UUID postId,
            @PathVariable UUID commentId,
            @RequestBody @Valid CommentRequestDto requestDto) {
        CommentResponseDto response = commentService.updateComment(postId, commentId, requestDto);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 삭제
    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<ApiResponse<UUID>> deleteComment(
            @PathVariable UUID postId,
            @PathVariable UUID commentId) {
        UUID deletedId = commentService.deleteComment(postId, commentId);
        return ResponseEntity.ok(ApiResponse.success(deletedId));
    }
}
