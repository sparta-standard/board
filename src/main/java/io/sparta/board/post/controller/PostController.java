package io.sparta.board.post.controller;

import io.sparta.board.post.dto.requestDto.PostRequestDto;
import io.sparta.board.post.dto.responseDto.PostDetailsResponseDto;
import io.sparta.board.post.dto.responseDto.PostResponseDto;
import io.sparta.board.post.dto.responseDto.PostUpdateResponseDto;
import io.sparta.board.post.service.PostService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    // 게시물 단일 조회
    @GetMapping("/{post_id}")
    public ResponseEntity<PostDetailsResponseDto>  getPost(
        @PathVariable UUID post_id,
        @RequestParam(required = false, defaultValue = "0") Integer page,
        @RequestParam(required = false, defaultValue = "10") Integer size){
        PostDetailsResponseDto responseDto = postService.getPost(post_id, page, size);
        return ResponseEntity.ok(responseDto);
    }

    // 게시물 전체 조회
    @GetMapping
    public ResponseEntity<Page<PostResponseDto>> getPosts(
        @RequestParam(required = false, defaultValue = "0") Integer page,
        @RequestParam(required = false, defaultValue = "10") Integer size){
        Page<PostResponseDto> responseDtos = postService.getPosts(page, size);
        return ResponseEntity.ok(responseDtos);
    }

    // 게시물 생성
    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto requestDto){
        PostResponseDto responseDto = postService.createPost(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 게시물 수정
    @PutMapping("/{post_id}")
    public ResponseEntity<PostUpdateResponseDto> updatePost(
        @PathVariable("post_id") UUID postId,
        @RequestBody PostRequestDto requestDto){
        PostUpdateResponseDto responseDto = postService.updatePost(postId, requestDto);
        return ResponseEntity.ok(responseDto);
    }

}
