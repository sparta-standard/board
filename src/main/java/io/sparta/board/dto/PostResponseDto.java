package io.sparta.board.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostResponseDto {

	private UUID postId;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private List<CommentResponseDto> commentList;

	public static PostResponseDto from(UUID postId, String title, String content, LocalDateTime createdAt) {
		return PostResponseDto.builder()
			.postId(postId)
			.title(title)
			.content(content)
			.createdAt(createdAt)
			.build();
	}
}
