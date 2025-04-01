package io.sparta.board.app.domain.comment.presentation.controller;

import io.sparta.board.app.domain.comment.application.facade.CommentFacade;
import io.sparta.board.app.domain.comment.presentation.dto.request.CommentCreateRequestDto;
import io.sparta.board.app.domain.comment.presentation.dto.request.CommentUpdateRequestDto;
import io.sparta.board.app.domain.comment.presentation.dto.response.CommentCreateResponseDto;
import io.sparta.board.app.domain.comment.presentation.dto.response.CommentUpdateResponseDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

	private final CommentFacade commentFacade;

	@PostMapping
	public ResponseEntity<CommentCreateResponseDto> CreateComment(@RequestBody
		CommentCreateRequestDto commentCreateRequestDto) {
		return ResponseEntity.ok(commentFacade.createComment(commentCreateRequestDto));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<CommentUpdateResponseDto> UpdateComment(@PathVariable("id") UUID id, @RequestBody
	CommentUpdateRequestDto commentUpdateRequestDto) {
		return ResponseEntity.ok(commentFacade.updateComment(id, commentUpdateRequestDto));
	}
}
