package io.sparta.board.presentaion;

import io.sparta.board.application.CommentService;
import io.sparta.board.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {

  private final CommentService commentService;

  //댓글 생성
  @PostMapping("/create")
  public ResponseEntity<String> createComment(@RequestBody Comment comment) {

    commentService.save(comment);
    return ResponseEntity.ok("생성");
  }
}
