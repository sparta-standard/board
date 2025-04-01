package io.sparta.board.app.domain.post.presentation.controller;

import io.sparta.board.app.domain.post.application.facade.PostFacade;
import io.sparta.board.app.domain.post.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostCreatResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
	private final PostFacade postFacade;

	@PostMapping
	public ResponseEntity<PostCreatResponseDto> createPost(@RequestBody PostCreateRequestDto postCreatRequestDto) {
		return ResponseEntity.ok(postFacade.createPost(postCreatRequestDto));
	}

}
