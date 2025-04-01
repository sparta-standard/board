package io.sparta.board.post.controller;

import io.sparta.board.post.dto.responseDto.PostDetailsResponseDto;
import io.sparta.board.post.service.PostService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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




}
