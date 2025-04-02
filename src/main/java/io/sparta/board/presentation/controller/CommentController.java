package io.sparta.board.presentation.controller;

import io.sparta.board.application.facade.CommentFacade;
import io.sparta.board.presentation.dto.request.CommentCreateRequestDto;
import io.sparta.board.presentation.dto.response.CommentResponseDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentFacade commentFacade;

    @PostMapping("/{id}")
    public ResponseEntity<CommentResponseDto> createComment(
        @RequestBody CommentCreateRequestDto requestDto,
        @PathVariable("id") UUID postId
    ) {
        return ResponseEntity.ok(commentFacade.createComment(requestDto, postId));
    }
}
