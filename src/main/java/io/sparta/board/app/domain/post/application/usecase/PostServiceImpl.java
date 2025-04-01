package io.sparta.board.app.domain.post.application.usecase;

import io.sparta.board.app.domain.post.model.entity.Post;
import io.sparta.board.app.domain.post.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.app.domain.post.presentation.dto.response.PostCreatResponseDto;
import io.sparta.board.app.domain.post.model.repository.PostRepository;
import io.sparta.board.app.domain.post.presentation.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
	private final PostRepository postRepository;

	@Override
	public PostCreatResponseDto createPost(PostCreateRequestDto postCreatRequestDto) {
		Post newPost = PostMapper.postCreatRequestDtoToEntity(postCreatRequestDto);
		Post createdPost = postRepository.save(newPost);
		return PostMapper.EntityToCreateResponseDto(createdPost);
	}
}
