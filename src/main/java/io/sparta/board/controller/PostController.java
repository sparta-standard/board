package io.sparta.board.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.sparta.board.dto.PostRequestDto;
import io.sparta.board.dto.PostResponseDto;
import io.sparta.board.service.PostService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

	private final PostService postService;

	//게시글 작성
	@PostMapping
	public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
		return postService.createPost(requestDto);
	}

	//게시글 수정
	@PutMapping("/{postId}")
	public PostResponseDto updatePost(@PathVariable("postId") UUID postId, @RequestBody PostRequestDto requestDto) {
		return postService.updatePost(postId, requestDto);
	}

	//게시글 삭제
	@DeleteMapping("/{postId}")
	public PostResponseDto deletePost(@PathVariable("postId") UUID postId) {
		return postService.deletePost(postId);
	}

	//게시글 단건 조회
	@GetMapping("/{postId}")
	public PostResponseDto getPost(@PathVariable("postId") UUID postId) {
		return postService.getPost(postId);
	}
}
