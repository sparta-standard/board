package io.sparta.board.presentation.controller;
import io.sparta.board.application.dto.response.CommentCreateResponseDto;
import io.sparta.board.application.dto.response.CommentUpdateResponseDto;
import io.sparta.board.application.dto.response.DeleteCommentResponseDto;
import io.sparta.board.application.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
@Slf4j
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{postId}")
    public ResponseEntity<CommentCreateResponseDto> create(@RequestBody Map<String, String> request, @PathVariable UUID postId) {
        CommentCreateResponseDto responseDto = commentService.create(postId, request);
        return ResponseEntity.ok().body(responseDto);
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<CommentUpdateResponseDto> update(@RequestBody Map<String, String> request,
                                    @PathVariable UUID commentId) {
        CommentUpdateResponseDto update = commentService.update(commentId, request);
        return ResponseEntity.ok().body(update);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<DeleteCommentResponseDto> delete(@PathVariable UUID commentId) {
        DeleteCommentResponseDto delete = commentService.delete(commentId);
        return ResponseEntity.ok().body(delete);
    }

}
