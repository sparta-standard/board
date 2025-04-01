package io.sparta.board.post.controller;

import io.sparta.board.post.dto.PostRequestDto;
import io.sparta.board.post.dto.PostResponseDto;
import io.sparta.board.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
