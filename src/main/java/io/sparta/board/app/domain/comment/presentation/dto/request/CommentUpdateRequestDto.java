package io.sparta.board.app.domain.comment.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentUpdateRequestDto {
	@JsonProperty("post-id")
	private UUID postId;
	private String content;
}
