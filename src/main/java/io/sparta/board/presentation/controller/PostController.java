package io.sparta.board.presentation.controller;

import io.sparta.board.application.service.PostService;
import io.sparta.board.presentation.dto.request.CreatePostRequestDto;
import io.sparta.board.presentation.dto.request.UpdatePostRequestDto;
import io.sparta.board.presentation.dto.response.CreatePostResponseDto;
import io.sparta.board.presentation.dto.response.GetPostResponseDto;
import io.sparta.board.presentation.dto.response.UpdatePostResponseDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    //게시글 작성
    @PostMapping
    public ResponseEntity<CreatePostResponseDto> createPost(@RequestBody CreatePostRequestDto requestDto) {
        CreatePostResponseDto responseDto = postService.createPost(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    //게시글 수정
    @PatchMapping("/{postId}")
    public ResponseEntity<UpdatePostResponseDto> updatePost(@PathVariable UUID postId, @RequestBody UpdatePostRequestDto requestDto) {
        UpdatePostResponseDto responseDto = postService.updatePost(postId, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    //게시글 삭제
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID postId) {
        Void response = postService.deletePost(postId);
        return ResponseEntity.ok(response);
    }

    //게시글 조회 + 댓글조회
    @GetMapping("/{postId}")
    public ResponseEntity<GetPostResponseDto> getPost(@PathVariable UUID postId){
        GetPostResponseDto responseDto = postService.getPost(postId);
        return ResponseEntity.ok(responseDto);
    }

}
