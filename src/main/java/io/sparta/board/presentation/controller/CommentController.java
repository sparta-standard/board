package io.sparta.board.presentation.controller;

import io.sparta.board.application.service.CommentService;
import io.sparta.board.presentation.dto.request.CreateCommentRequestDto;
import io.sparta.board.presentation.dto.request.UpdateCommentRequestDto;
import io.sparta.board.presentation.dto.response.CreateCommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;
    //댓글생성
    @PostMapping
    public ResponseEntity<CreateCommentResponseDto> CreateComment(CreateCommentRequestDto requestDto) {
        CreateCommentResponseDto responseDto = commentService.createComment(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    //댓글수정
    @PatchMapping
    public void updateComment(UpdateCommentRequestDto requestDto) {

    }

}
