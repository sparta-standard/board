package io.sparta.board.domain.comment.controller;

import io.sparta.board.domain.comment.dto.requeset.CommentCreateRequestDto;
import io.sparta.board.domain.comment.dto.requeset.CommentUpdateRequestDto;
import io.sparta.board.domain.comment.dto.response.CommentResponseDto;
import io.sparta.board.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentCotroller {

    private final CommentService commentService;

    //댓글 등록
    @PostMapping("/{postId}")
    public ResponseEntity<CommentResponseDto> createComment(
            @RequestBody CommentCreateRequestDto request,
            @PathVariable UUID postId
    ){
        CommentResponseDto response = commentService.createComment(request, postId);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //댓글 수정
    @PatchMapping("/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @PathVariable UUID id,
            @RequestBody CommentUpdateRequestDto request
    ){
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        CommentResponseDto response = commentService.updateComment(id, request);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //댓글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<CommentResponseDto> deleteComment(
            @PathVariable UUID id
    ){

        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        commentService.deleteComment(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
