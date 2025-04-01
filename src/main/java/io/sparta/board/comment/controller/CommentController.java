package io.sparta.board.comment.controller;

import io.sparta.board.comment.dto.requestDto.CommentCreateRequestDto;
import io.sparta.board.comment.dto.requestDto.CommentUpdateRequestDto;
import io.sparta.board.comment.dto.responseDto.CommentCreateResponseDto;
import io.sparta.board.comment.dto.responseDto.CommentUpdateResponseDto;
import io.sparta.board.comment.service.CommentService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    // 댓글 등록
    @PostMapping
    public ResponseEntity<CommentCreateResponseDto> createComment(@RequestBody CommentCreateRequestDto requestDto) {
        CommentCreateResponseDto responseDto = commentService.createComment(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 댓글 수정
    @PutMapping("/{comment_id}")
    public ResponseEntity<CommentUpdateResponseDto>  updateComment(
        @PathVariable("comment_id") UUID commentId,
        @RequestBody CommentUpdateRequestDto requestDto) {

        CommentUpdateResponseDto responseDto = commentService.updateComment(commentId, requestDto);
        return ResponseEntity.ok(responseDto);
    }


}
