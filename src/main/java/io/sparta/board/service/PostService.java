package io.sparta.board.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.sparta.board.dto.PostRequestDto;
import io.sparta.board.dto.PostResponseDto;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.CommentRepository;
import io.sparta.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PostService {

	private final PostRepository postRepository;
	private final CommentRepository commentRepository;

	@Transactional
	public PostResponseDto createPost(PostRequestDto requestDto) {
		Post post = Post.createPost(requestDto.getTitle(), requestDto.getContent());
		postRepository.save(post);

		return PostResponseDto.from(post.getPostId(), post.getTitle(), post.getContent(), post.getCreatedAt());
	}

	@Transactional
	public PostResponseDto updatePost(UUID postId, PostRequestDto requestDto) {
		Post post = postRepository.findByPostIdAndDeletedFalse(postId)
			.orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
		post.update(requestDto.getTitle(), requestDto.getContent());
		postRepository.save(post);

		return PostResponseDto.from(post.getPostId(), post.getTitle(), post.getContent(), post.getCreatedAt());
	}

	@Transactional
	public PostResponseDto deletePost(UUID postId) {
		Post post = postRepository.findByPostIdAndDeletedFalse(postId)
			.orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
		post.delete(true);
		postRepository.save(post);

		return PostResponseDto.from(post.getPostId(), post.getTitle(), post.getContent(), post.getCreatedAt());
	}

	public PostResponseDto getPost(UUID postId) {
		Post post = postRepository.findByPostIdAndDeletedFalse(postId)
			.orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

		return new PostResponseDto(post);
	}
}
