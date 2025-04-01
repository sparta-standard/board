package io.sparta.board.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "p_post")
public class Post extends Timestamped{

	@Id
	@GeneratedValue
	private UUID postId;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = false)
	private String content;

	@Column(nullable = false)
	private boolean deleted;

	@OneToMany(mappedBy = "post")
	private List<Comment> commentList = new ArrayList<>();

	public static Post createPost(String title, String content) {
		Post post = new Post();
		post.title = title;
		post.content = content;
		post.deleted = false;
		return post;
	}

	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public void delete(boolean b) {
		this.deleted = b;
	}
}
