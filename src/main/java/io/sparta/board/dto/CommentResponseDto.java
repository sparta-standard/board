package io.sparta.board.dto;

import java.util.UUID;

import io.sparta.board.entity.Comment;
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

	public CommentResponseDto(Comment comment) {
		this.commentId = comment.getCommentId();
		this.postId = comment.getPost().getPostId();
		this.content = comment.getContent();
	}

	public static CommentResponseDto from (UUID commentId, UUID postId, String content) {
		return CommentResponseDto.builder()
			.commentId(commentId)
			.postId(postId)
			.content(content)
			.build();
	}
}
