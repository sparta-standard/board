package io.sparta.board.presentation;

import io.sparta.board.application.dto.request.comment.CommentCreateRequestDto;
import io.sparta.board.application.dto.request.comment.CommentUpdateRequestDto;
import io.sparta.board.application.dto.response.comment.CommentCreateResponseDto;
import io.sparta.board.application.dto.response.comment.CommentDeleteResponseDto;
import io.sparta.board.application.dto.response.comment.CommentUpdateResponseDto;
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

    @PutMapping("/{id}/updateComment")
    public ResponseEntity<CommentUpdateResponseDto> updateComment(
            @PathVariable UUID id,
            @RequestBody CommentUpdateRequestDto request){
        CommentUpdateResponseDto response = commentService.updateComment(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommentDeleteResponseDto> deleteComment(
            @PathVariable UUID id){
        CommentDeleteResponseDto response = commentService.deleteComment(id);
        return ResponseEntity.ok(response);
    }
}
