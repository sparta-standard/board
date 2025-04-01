package io.sparta.board.app.domain.post.presentation.mapper;

import io.sparta.board.app.domain.post.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.app.domain.post.model.entity.Post;
import io.sparta.board.app.domain.post.presentation.dto.response.PostCreatResponseDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostUpdateResponseDto;

public class PostMapper {
	public static Post postCreatRequestDtoToEntity(PostCreateRequestDto postCreateRequestDto) {
		return Post.builder()
			.title(postCreateRequestDto.getTitle())
			.content(postCreateRequestDto.getContent())
			.build();
	}

	public static PostCreatResponseDto EntityToCreateResponseDto(Post post) {
		return PostCreatResponseDto.builder()
			.id(post.getId())
			.build();
	}

	public static PostUpdateResponseDto EntityToUpdateResponseDto(Post post) {
		return PostUpdateResponseDto.builder()
			.id(post.getId())
			.title(post.getTitle())
			.content(post.getContent())
			.build();
	}



}
