package io.sparta.board.controller;

import io.sparta.board.dto.request.CommentCreateRequestDto;
import io.sparta.board.dto.request.CommentUpdateRequestDto;
import io.sparta.board.dto.response.CommentDetailResponseDto;
import io.sparta.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDetailResponseDto> createComment(
            @PathVariable UUID postId,
            @RequestBody CommentCreateRequestDto dto
    ) {
        return ResponseEntity.ok(commentService.createComment(postId, dto));
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentDetailResponseDto>> getCommentsByPost(
            @PathVariable UUID postId
    ) {
        return ResponseEntity.ok(commentService.getCommentsByPost(postId));
    }

    @PutMapping("/comments/{commentId}")
    public ResponseEntity<CommentDetailResponseDto> updateComment(
            @PathVariable UUID commentId,
            @RequestBody CommentUpdateRequestDto dto
    ) {
        return ResponseEntity.ok(commentService.updateComment(commentId, dto));
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable UUID commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}
