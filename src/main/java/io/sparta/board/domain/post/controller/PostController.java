package io.sparta.board.domain.post.controller;

import io.sparta.board.domain.post.dto.request.PostCreateRequestDto;
import io.sparta.board.domain.post.dto.response.PostResponseDto;
import io.sparta.board.domain.post.service.PostServcie;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
