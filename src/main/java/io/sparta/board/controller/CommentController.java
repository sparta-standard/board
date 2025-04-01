package io.sparta.board.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.sparta.board.dto.CommentRequestDto;
import io.sparta.board.dto.CommentResponseDto;
import io.sparta.board.service.CommentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CommentController {

	private final CommentService commentService;

	//댓글 추가
	@PostMapping("/posts/{postId}/comments")
	public CommentResponseDto createComment(@PathVariable("postId") UUID postId, @RequestBody CommentRequestDto requestDto) {
		return commentService.createComment(postId, requestDto);
	}

	//댓글 수정
	@PutMapping("/comments/{commentId}")
	public CommentResponseDto updateComment(@PathVariable("commentId") UUID commentId, @RequestBody CommentRequestDto requestDto) {
		return commentService.updateComment(commentId, requestDto);
	}

	//댓글 삭제
	@DeleteMapping("/comments/{commentId}")
	public CommentResponseDto deleteComment(@PathVariable("commentId") UUID commentId) {
		return commentService.deleteComment(commentId);
	}
}
