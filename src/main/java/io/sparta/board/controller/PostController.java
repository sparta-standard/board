package io.sparta.board.controller;


import io.sparta.board.dto.PostRequestDto;
import io.sparta.board.dto.PostResponseDto;
import io.sparta.board.entity.Post;
import io.sparta.board.service.PostService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

  private final PostService postService;

  @PostMapping
  public ResponseEntity<UUID> createPost(@RequestBody PostRequestDto requestDto) {
    UUID postId = postService.createPost(requestDto);
    return ResponseEntity.ok(postId);
  }

  @GetMapping("/{postId}")
  public ResponseEntity<PostResponseDto> getPost(@PathVariable UUID postId) {
    return ResponseEntity.ok(postService.getPost(postId));
  }

  @PutMapping("/{postId")
  public ResponseEntity<Void> updatePost(@PathVariable UUID postId, @RequestBody PostRequestDto requestDto) {
    postService.updatePost(postId, requestDto);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{postId}")
  public ResponseEntity<Void> deletePost(@PathVariable UUID postId) {
    postService.deletePost(postId);
    return ResponseEntity.ok().build();
  }

}
