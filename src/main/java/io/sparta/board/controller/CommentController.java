package io.sparta.board.controller;

import io.sparta.board.dto.request.CommentCreateRequestDto;
import io.sparta.board.dto.request.CommentUpdateRequestDto;
import io.sparta.board.dto.response.CommentResponseDto;
import io.sparta.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentCreateRequestDto requestDto){
        return ResponseEntity.ok(commentService.createComment(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(@PathVariable UUID id,
                                                            @RequestBody CommentUpdateRequestDto requestDto){
        return ResponseEntity.ok(commentService.updateComment(id,requestDto));
    }

}
