package io.sparta.board.presentation;

import io.sparta.board.application.dto.request.CommentCreateRequestDto;
import io.sparta.board.application.dto.response.CommentCreateResponseDto;
import io.sparta.board.application.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/boards/{id}/comments")
    public ResponseEntity<CommentCreateResponseDto> createComment(
            @PathVariable UUID id,
            @RequestBody CommentCreateRequestDto request){

        CommentCreateResponseDto response = commentService.createComment(id, request);
        return ResponseEntity.ok(response);
    }
}
