package io.sparta.board.controller;

import io.sparta.board.dto.CommentRequestDto;
import io.sparta.board.dto.CommentResponseDto;
import io.sparta.board.service.CommentService;
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
    public CommentResponseDto addComment(@PathVariable UUID postId, @RequestBody CommentRequestDto requestDto) {
        return commentService.addComment(postId, requestDto);
    }

    // 수정
    @PutMapping("/{postId}/comments/{commentId}")
    public CommentResponseDto updateComment(
            @PathVariable UUID postId,
            @PathVariable UUID commentId,
            @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(postId, commentId, requestDto);
    }
}
