package io.sparta.board.app.domain.post.application.usecase;

import io.sparta.board.app.domain.post.model.entity.Post;
import io.sparta.board.app.domain.post.model.repository.PostQueryRepository;
import io.sparta.board.app.domain.post.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.app.domain.post.presentation.dto.request.PostUpdateRequestDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostCreatResponseDto;
import io.sparta.board.app.domain.post.model.repository.PostRepository;
import io.sparta.board.app.domain.post.presentation.dto.response.PostDeleteResponseDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostReadResponseDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostUpdateResponseDto;
import io.sparta.board.app.domain.post.presentation.mapper.PostMapper;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
	private final PostRepository postRepository;
	private final PostQueryRepository postQueryRepository;

	@Override
	public PostCreatResponseDto createPost(PostCreateRequestDto postCreatRequestDto) {
		Post newPost = PostMapper.postCreatRequestDtoToEntity(postCreatRequestDto);
		Post createdPost = postRepository.save(newPost);
		return PostMapper.EntityToCreateResponseDto(createdPost);
	}

	@Override
	public PostReadResponseDto readPost(UUID id, Pageable pageable) {
		Page<Post> postCommentList = postQueryRepository.findPostCommentList(id, pageable);
		return PostMapper.pageToReadResponseDto(postCommentList);
	}

	@Override
	public PostUpdateResponseDto updatePost(UUID id, PostUpdateRequestDto postUpdateRequestDto) {
		Post post = postRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Post not found"));
		post.update(postUpdateRequestDto);
		return PostMapper.EntityToUpdateResponseDto(post);
	}

	@Override
	public PostDeleteResponseDto deletePost(UUID id) {
		Post post = postRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Post not found"));
		post.delete(true);

		return PostMapper.entityToDeleteResponseDto(post);
	}
}
