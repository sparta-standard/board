package io.sparta.board.post.controller;

import io.sparta.board.post.dto.PostRequestDto;
import io.sparta.board.post.dto.PostResponseDto;
import io.sparta.board.post.dto.PostUpdateRequestDto;
import io.sparta.board.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    // 게시글 등록
    @PostMapping
    public ResponseEntity<PostResponseDto> createPost
            (@RequestBody PostRequestDto requestDto) {

        PostResponseDto responseDto = postService.createPost(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    // 게시글 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPostWithComments(
            @PathVariable UUID id,
            @PageableDefault(page = 0, size = 10, sort = "createdAt", direction = Sort.Direction.ASC) Pageable pageable) {

        PostResponseDto responseDto = postService.getPostWithComments(id, pageable);
        return ResponseEntity.ok(responseDto);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePost(
            @PathVariable UUID id,
            @RequestBody PostUpdateRequestDto requestDto) {

        PostResponseDto responseDto = postService.updatePost(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

}
