package io.sparta.board.controller;

import io.sparta.board.dto.request.CommentCreateRequestDto;
import io.sparta.board.dto.response.CommentResponseDto;
import io.sparta.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentCreateRequestDto requestDto){
        return ResponseEntity.ok(commentService.createComment(requestDto));
    }


}
