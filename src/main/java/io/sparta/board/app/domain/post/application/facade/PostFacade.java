package io.sparta.board.app.domain.post.application.facade;

import io.sparta.board.app.domain.post.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.app.domain.post.presentation.dto.request.PostUpdateRequestDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostCreatResponseDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostUpdateResponseDto;
import java.util.UUID;

public interface PostFacade {

	PostCreatResponseDto createPost(PostCreateRequestDto postCreatRequestDto);

	PostUpdateResponseDto updatePost(UUID id, PostUpdateRequestDto postUpdateRequestDto);
}
