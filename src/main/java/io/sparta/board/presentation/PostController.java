package io.sparta.board.presentation;

import io.sparta.board.application.dto.request.PostCreateRequestDto;
import io.sparta.board.application.dto.response.PostCreateResponseDto;
import io.sparta.board.application.dto.response.PostGetResponseDto;
import io.sparta.board.application.dto.response.comment.PostUpdateRequestDto;
import io.sparta.board.application.dto.response.post.PostUpdateResponseDto;
import io.sparta.board.application.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostCreateResponseDto> createPost(
            @RequestBody PostCreateRequestDto request) {
        PostCreateResponseDto response = postService.createPost(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostGetResponseDto> GetPost(
            @PathVariable UUID id){

        PostGetResponseDto response = postService.getDetailPost(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<PostUpdateResponseDto> updatePost(
            @PathVariable UUID id,
            @RequestBody PostUpdateRequestDto request){
        PostUpdateResponseDto response = postService.updatePost(id, request);
        return ResponseEntity.ok(response);
    }
}
