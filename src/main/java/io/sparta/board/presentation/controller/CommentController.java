package io.sparta.board.presentation.controller;

import io.sparta.board.application.service.CommentService;
import io.sparta.board.presentation.dto.request.CreateCommentRequestDto;
import io.sparta.board.presentation.dto.request.UpdateCommentRequestDto;
import io.sparta.board.presentation.dto.response.CreateCommentResponseDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;
    //댓글생성
    @PostMapping("/{postId}")
    public ResponseEntity<CreateCommentResponseDto> CreateComment(@PathVariable UUID postId, @RequestBody CreateCommentRequestDto requestDto) {
        CreateCommentResponseDto responseDto = commentService.createComment(postId, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    //댓글수정
    @PatchMapping("/{commentId}")
    public ResponseEntity<Void> updateComment(@PathVariable UUID commentId, @RequestBody UpdateCommentRequestDto requestDto) {
        Void response = commentService.updateComment(commentId, requestDto);
        return ResponseEntity.ok(response);
    }

    //댓글삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable UUID commentId) {
        Void response = commentService.deleteComment(commentId);
        return ResponseEntity.ok(response);
    }



}
