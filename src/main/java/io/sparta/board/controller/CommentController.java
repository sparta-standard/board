package io.sparta.board.controller;

import io.sparta.board.dto.CommentRequestDto;
import io.sparta.board.dto.CommentResponseDto;
import io.sparta.board.entity.Comment;
import io.sparta.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    /*
    TODO 댓글 등록
    - 댓글 내용은 필수 항목
    - 댓글 등록 일자 자동 기록
     */
    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(
            @RequestBody CommentRequestDto req, @PathVariable UUID postId) {
        CommentResponseDto createComment = commentService.createComment(req, postId);
        return ResponseEntity.ok(createComment);
    }

    /*
    TODO 댓글 수정
    - 댓글 내용만 수정 가능
    - 댓글 수정 일자 자동 기록
     */
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @PathVariable UUID commentId, @RequestBody CommentRequestDto req) {
        CommentResponseDto updatedComment = commentService.updateComment(commentId, req);
        return ResponseEntity.ok(updatedComment);
    }

    /*
    TODO 댓글 삭제
    - 삭제 후 복구 불가능
    - 댓글 삭제 시 삭제 상태에 대한 변경만 처리(soft-delete)
     */
    @DeleteMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> deleteComment(@PathVariable UUID commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}
