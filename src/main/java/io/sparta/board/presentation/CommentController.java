package io.sparta.board.presentation;

import io.sparta.board.application.dto.request.CommentCreateRequestDto;
import io.sparta.board.application.dto.request.CommentUpdateRequestDto;
import io.sparta.board.application.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/{post_id}/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 등록
     */
    @PostMapping
    public ResponseEntity<Void> createComment(@PathVariable("post_id") UUID postId,
                                              @RequestBody CommentCreateRequestDto dto) {
        commentService.createComment(postId, dto);
        return ResponseEntity.ok().build();
    }

    /**
     * 댓글 수정
     */
    @PutMapping("/{comment_id}")
    public ResponseEntity<Void> updateComment(@PathVariable("post_id") UUID postId,
                                              @PathVariable("comment_id") UUID commentId,
                                              @RequestBody CommentUpdateRequestDto dto) {
        commentService.updateComment(postId, commentId, dto);
        return ResponseEntity.ok().build();
    }

    /**
     * 댓글 삭제
     */
    @DeleteMapping("/{comment_id}")
    public ResponseEntity<Void> deleteComment(@PathVariable("post_id") UUID postId,
                                              @PathVariable("comment_id") UUID commentId) {
        commentService.deleteComment(postId, commentId);
        return ResponseEntity.ok().build();
    }
}
