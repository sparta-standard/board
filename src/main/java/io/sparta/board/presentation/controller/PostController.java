package io.sparta.board.presentation.controller;

import io.sparta.board.application.dto.request.PostCreationRequestDto;
import io.sparta.board.application.dto.request.PostUpdateRequestDto;
import io.sparta.board.application.dto.response.PostCreationResponseDto;
import io.sparta.board.application.dto.response.PostUpdateResponseDto;
import io.sparta.board.application.service.PostService;
import io.sparta.board.domain.model.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Slf4j
public class PostController {
    private final PostService postService;

    /* 통신 확인용
    @GetMapping
    public String home() {
        log.info("GET /post");
        return "GET /post";
    }
    */

    @PostMapping
    public ResponseEntity<PostCreationResponseDto> postCreate(@RequestBody PostCreationRequestDto dto) {
        log.info("Post Method - 게시글 작성: dto = {}", dto.toString());
        PostCreationResponseDto responseDto = postService.postCreate(dto);
        return ResponseEntity.ok().body(responseDto);
    }
}
