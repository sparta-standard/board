package io.sparta.board.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class CommentResponseDto {

	private UUID commentId;
	private UUID postId;
	private String content;

	public static CommentResponseDto from (UUID commentId, UUID postId, String content) {
		return CommentResponseDto.builder()
			.commentId(commentId)
			.postId(postId)
			.content(content)
			.build();
	}
}
