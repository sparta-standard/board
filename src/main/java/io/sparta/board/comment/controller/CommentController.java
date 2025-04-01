package io.sparta.board.comment.controller;

import io.sparta.board.comment.dto.CommentRequestDto;
import io.sparta.board.comment.dto.CommentResponseDto;
import io.sparta.board.comment.dto.CommentUpdateRequestDto;
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

    // 댓글 수정
    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @PathVariable UUID postId,
            @PathVariable UUID id,
            @RequestBody CommentUpdateRequestDto requestDto) {

        CommentResponseDto responseDto = commentService.updateComment(postId, id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 댓글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(
            @PathVariable UUID postId,
            @PathVariable UUID id) {
        commentService.deleteComment(postId, id);

        return ResponseEntity.ok("댓글이 삭제되었습니다.");
    }
}
