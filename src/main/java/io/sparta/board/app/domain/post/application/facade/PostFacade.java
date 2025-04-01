package io.sparta.board.app.domain.post.application.facade;

import io.sparta.board.app.domain.post.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostCreatResponseDto;

public interface PostFacade {

	PostCreatResponseDto createPost(PostCreateRequestDto postCreatRequestDto);
}
