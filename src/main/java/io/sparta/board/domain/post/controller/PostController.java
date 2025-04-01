package io.sparta.board.domain.post.controller;

import io.sparta.board.domain.post.dto.request.PostCreateRequestDto;
import io.sparta.board.domain.post.dto.response.GetPostResponseDto;
import io.sparta.board.domain.post.dto.response.PostResponseDto;
import io.sparta.board.domain.post.service.PostServcie;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/post")
@AllArgsConstructor
public class PostController {

    PostServcie postService;
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






}
