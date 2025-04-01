package io.sparta.board.application.service;

import io.sparta.board.application.dto.mapper.PostMapper;
import io.sparta.board.application.dto.request.PostCreateRequestDto;
import io.sparta.board.application.dto.response.PostCreateResponseDto;
import io.sparta.board.domain.entity.Post;
import io.sparta.board.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public PostCreateResponseDto createPost(PostCreateRequestDto request){
        Post post = request.toEntity();
        Post savedPost = postRepository.save(post);
        PostCreateResponseDto response = PostMapper.toPostCreateResponseDto(savedPost);

        return response;
    }
}
