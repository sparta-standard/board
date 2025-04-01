package io.sparta.board.app.domain.post.presentation.mapper;

import io.sparta.board.app.domain.post.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.app.domain.post.model.entity.Post;
import io.sparta.board.app.domain.post.presentation.dto.response.PostCreatResponseDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostDeleteResponseDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostReadResponseDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostUpdateResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;

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

	public static PostReadResponseDto pageToReadResponseDto(Page<Post> page) {
		PostReadResponseDto.PostReadResponseDtoBuilder builder = PostReadResponseDto.builder();
		builder = builder
			.totalContents(page.getTotalElements())
			.size(page.getSize())
			.currentPage(page.getNumber() + 1);
		List<PostReadResponseDto.CommentDto> commentDtoList = page.getContent().stream()
			.map(PostMapper::entityToPostReadDto)
			.collect(Collectors.toList());
		builder = builder.commentList(commentDtoList);
		return builder.build();
	}

	private static PostReadResponseDto.CommentDto entityToPostReadDto(Post post) {
		return PostReadResponseDto.CommentDto.builder()
			.id(post.getId())
			.postId(post.getId())
			.content(post.getContent())
			.build();
	}

	public static PostUpdateResponseDto EntityToUpdateResponseDto(Post post) {
		return PostUpdateResponseDto.builder()
			.id(post.getId())
			.title(post.getTitle())
			.content(post.getContent())
			.build();
	}

	public static PostDeleteResponseDto entityToDeleteResponseDto(Post post) {
		return PostDeleteResponseDto.builder()
			.id(post.getId())
			.build();
	}
}
