package io.sparta.board.app.domain.post.application.usecase;

import io.sparta.board.app.domain.post.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostCreatResponseDto;

public interface PostService {

	PostCreatResponseDto createPost(PostCreateRequestDto postCreatRequestDto);
}
