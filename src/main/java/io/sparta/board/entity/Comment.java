package io.sparta.board.entity;

import java.util.UUID;

import io.sparta.board.dto.CommentRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "p_comment")
public class Comment extends Timestamped {

	@Id
	@GeneratedValue
	private UUID commentId;

	@Column(nullable = false)
	private String content;

	@Column(nullable = false)
	private boolean deleted;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;

	public static Comment createComment(Post post, CommentRequestDto requestDto) {

		Comment comment = new Comment();
		comment.post = post;
		comment.content = requestDto.getContent();
		comment.deleted = false;

		return comment;
	}

	public void update(String content) {
		this.content = content;
	}

	public void delete(boolean b) {
		this.deleted = b;
	}
}
