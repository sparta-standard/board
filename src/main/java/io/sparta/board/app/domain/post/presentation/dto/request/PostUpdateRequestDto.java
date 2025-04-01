package io.sparta.board.app.domain.post.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostUpdateRequestDto {
	private String title;
	private String content;
}
