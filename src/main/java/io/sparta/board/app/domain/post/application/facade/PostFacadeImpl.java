package io.sparta.board.app.domain.post.application.facade;

import io.sparta.board.app.domain.post.application.usecase.PostService;
import io.sparta.board.app.domain.post.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.app.domain.post.presentation.dto.request.PostUpdateRequestDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostCreatResponseDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostUpdateResponseDto;
import java.util.UUID;
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

	@Override
	public PostUpdateResponseDto updatePost(UUID id,PostUpdateRequestDto postUpdateRequestDto) {
		return postService.updatePost(id, postUpdateRequestDto);
	}
}
