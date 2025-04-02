package io.sparta.board.presentation;

import io.sparta.board.application.dto.request.PostCreateRequestDto;
import io.sparta.board.application.dto.request.PostUpdateRequestDto;
import io.sparta.board.application.dto.response.PostGetResponseDto;
import io.sparta.board.application.dto.response.PostResponseDto;
import io.sparta.board.application.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    /**
     * 게시글 작성
     */
    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostCreateRequestDto dto) {
        postService.createPost(dto);
        return ResponseEntity.ok().build();
    }

    /**
     * 게시글 수정
     */
    @PutMapping("/{post_id}")
    public ResponseEntity<Void> updatePost(@PathVariable("post_id") UUID id,
                                           @RequestBody PostUpdateRequestDto dto) {
        postService.updatePost(id, dto);
        return ResponseEntity.ok().build();
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/{post_id}")
    public ResponseEntity<Void> deletePost(@PathVariable("post_id") UUID id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }

    /**
     * 게시글 단건 조회
     */
    @GetMapping("/{post_id}")
    public ResponseEntity<PostGetResponseDto> getPost(@PathVariable("post_id") UUID id) {
        return ResponseEntity.ok().body(postService.getPost(id));
    }


    /**
     * 게시글 목록 조회
     */
    @GetMapping
    public ResponseEntity<Page<PostResponseDto>> getPostList (@RequestParam(defaultValue = "1") int page,
                                                              @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok().body(postService.getPostList(page, size));
    }
}
