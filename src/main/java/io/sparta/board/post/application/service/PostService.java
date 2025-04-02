package io.sparta.board.post.application.service;

import io.sparta.board.post.application.dto.request.PostRequestDto;
import io.sparta.board.post.application.dto.response.PostResponseDto;
import io.sparta.board.post.application.mapper.PostMapper;
import io.sparta.board.post.domain.entity.Post;
import io.sparta.board.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostResponseDto createPost(PostRequestDto dto) {
        Post post = PostMapper.toEntity(dto);
        Post savedPost = postRepository.save(post);

        return PostResponseDto.builder()
                .message("게시글이 생성되었습니다.")
                .stateCode(201)
                .post(PostMapper.toPostData(savedPost))
                .build();
    }
}