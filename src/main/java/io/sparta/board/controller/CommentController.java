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

    @PostMapping("/{postId}/comments")
    public CommentResponseDto addComment(@PathVariable UUID postId, @RequestBody CommentRequestDto requestDto) {
        return commentService.addComment(postId, requestDto);
    }
}
