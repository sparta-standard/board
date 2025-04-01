package io.sparta.board.domain.post.controller;

import io.sparta.board.domain.post.dto.request.PostCreateRequestDto;
import io.sparta.board.domain.post.dto.request.PostUpdateRequestDto;
import io.sparta.board.domain.post.dto.response.GetPostResponseDto;
import io.sparta.board.domain.post.dto.response.PostResponseDto;
import io.sparta.board.domain.post.dto.response.PostUpdateResponse;
import io.sparta.board.domain.post.service.PostServcie;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostServcie postService;
    //게시글 작성
    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(
            @RequestBody PostCreateRequestDto request
    ) {

        if(request.getTitle() == null || request.getTitle().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if(request.getContent() == null || request.getContent().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        PostResponseDto response = postService.createPost(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    //게시글 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<GetPostResponseDto> getPost(
            @PathVariable UUID id
    ){
        if(id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        GetPostResponseDto responseDto = postService.getPost(id);

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    //게시글 수정
    @PatchMapping("/{id}")
    public ResponseEntity<PostUpdateResponse> updatePost(
            @PathVariable UUID id,
            @RequestBody PostUpdateRequestDto request
    ){
        if(id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }

        PostUpdateResponse responseDto = postService.updatePost(id, request);

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    //게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(
            @PathVariable UUID id
    ){
        if(id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        postService.deletePost(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
