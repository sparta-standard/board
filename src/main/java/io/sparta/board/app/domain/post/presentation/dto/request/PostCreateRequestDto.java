package io.sparta.board.app.domain.post.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostCreateRequestDto {

	private String title;

	private String content;
}
