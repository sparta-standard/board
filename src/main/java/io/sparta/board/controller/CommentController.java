package io.sparta.board.controller;


import io.sparta.board.dto.CommentRequestDto;
import io.sparta.board.entity.Comment;
import io.sparta.board.service.CommentService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

  private final CommentService commentService;

  @PostMapping("/post/{postId}")
  public ResponseEntity<UUID> createComment(@PathVariable UUID postId, @RequestBody
      CommentRequestDto requestDto) {
    UUID commentId = commentService.createComment(postId, requestDto);
    return ResponseEntity.ok(commentId);
  }

  @PutMapping("/{commentId}")
  public ResponseEntity<Void> updateComment(@PathVariable UUID commentId, @RequestBody CommentRequestDto requestDto) {
    commentService.updateComment(commentId, requestDto);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{commentId}")
  public ResponseEntity<Void> deleteComment(@PathVariable UUID commentId) {
    commentService.deleteComment(commentId);
    return ResponseEntity.ok().build();
  }

}
