package io.sparta.board.controller;

import io.sparta.board.dto.PostRequestDto;
import io.sparta.board.dto.PostResponseDto;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.PostRepository;
import io.sparta.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    /*
    TODO 게시글 작성
    - 게시글 제목, 내용은 필수 항목
    - 게시글 작성 일자 자동 기록
     */
    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto requestDto) {
        PostResponseDto createdPost = postService.createPost(requestDto);
        return  ResponseEntity.ok(createdPost);
    }

    /*
    TODO 게시글 수정
    - 제목과 내용만 수정 가능
    - 게시글 수정 일자 자동 기록
     */
    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePost(@PathVariable UUID id,
                                                      @RequestBody PostRequestDto requestDto) {
        PostResponseDto updatedPost = postService.updatePost(id, requestDto);
        return ResponseEntity.ok(updatedPost);
    }

    /*
    TODO 게시글 삭제

     - 삭제 시 게시글과 함께 해당 게시글의 모든 댓글도 삭제 처리
     - 삭제 후 복구 불가능
     - 게시글 삭제 시 삭제 상태에 대한 변경만 처리(soft-delete)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    /*
    TODO 게시글 단건 조회
    - 게시글에 포함된 모든 댓글 목록을 조회
    - 삭제된 데이터는 조회 불가능
     */
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable UUID id) {
        PostResponseDto getPost = postService.getPostById(id);
        return ResponseEntity.ok(getPost);
    }
}
