package io.sparta.board.presentaion;

import io.sparta.board.application.PostService;
import io.sparta.board.domain.Post;
import io.sparta.board.infrastructure.PostRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;
  private final PostRepository postRepository;

  //게시글 생성
  @PostMapping("/create")
  public ResponseEntity<PostResponseDto> post(@RequestBody PostRequestDto postRequestDto) {

    postService.save(postRequestDto);

    return ResponseEntity.ok(postService.save(postRequestDto));
  }

  @PatchMapping("/{post_id}")
  public ResponseEntity updatePost(@PathVariable("post_id") UUID id,@RequestBody PostRequestDto postRequestDto) {
    postService.updatePost(id,postRequestDto);

    return ResponseEntity.ok(postService.updatePost(id,postRequestDto));
  }
}
