package io.sparta.board.app.domain.post.application.facade;

import io.sparta.board.app.domain.post.application.usecase.PostService;
import io.sparta.board.app.domain.post.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostCreatResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostFacadeImpl implements PostFacade {
	private final PostService postService;

	@Override
	public PostCreatResponseDto createPost(PostCreateRequestDto postCreatRequestDto) {
		return postService.createPost(postCreatRequestDto);
	}
}
