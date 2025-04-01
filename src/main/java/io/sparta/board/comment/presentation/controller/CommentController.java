package io.sparta.board.comment.presentation.controller;

import io.sparta.board.comment.application.dto.request.CommentCreateRequestDto;
import io.sparta.board.comment.application.dto.request.CommentUpdateRequestDto;
import io.sparta.board.comment.application.dto.response.CommentCreateResponseDto;
import io.sparta.board.comment.application.dto.response.CommentSearchResponseDto;
import io.sparta.board.comment.application.dto.response.CommentUpdateResponseDto;
import io.sparta.board.comment.application.service.CommentService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentCreateResponseDto> createComment(
        @PathVariable(name = "postId") UUID postId,
        @RequestBody CommentCreateRequestDto requestDto
    ) {
        CommentCreateResponseDto responseDto = commentService.createComment(postId, requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<Page<CommentSearchResponseDto>> searchComments(
        @PathVariable(name = "postId") UUID postId,
        Pageable pageable
    ) {
        Page<CommentSearchResponseDto> responseDtoPage = commentService.searchComments(postId, pageable);
        return ResponseEntity.ok(responseDtoPage);
    }

    @PatchMapping("/comments/{commentId}")
    public ResponseEntity<CommentUpdateResponseDto> updateComment(
        @PathVariable(name = "commentId") UUID commentId,
        @RequestBody CommentUpdateRequestDto requestDto
    ) {
        CommentUpdateResponseDto responseDto = commentService.updateComment(commentId, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<String> deleteComment(
        @PathVariable(name = "commentId") UUID commentId
    ) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("댓글 삭제 성공");
    }

}
