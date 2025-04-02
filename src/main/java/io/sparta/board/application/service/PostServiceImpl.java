package io.sparta.board.application.service;

import io.sparta.board.model.entity.Post;
import io.sparta.board.model.repository.PostRepository;
import io.sparta.board.presentation.dto.response.CreatePostResponseDto;
import io.sparta.board.presentation.dto.request.CreatePostRequestDto;
import io.sparta.board.presentation.dto.request.UpdatePostRequestDto;
import io.sparta.board.presentation.dto.response.UpdatePostResponseDto;
import io.sparta.board.presentation.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public CreatePostResponseDto createPost(CreatePostRequestDto requestDto) {
        //dto 로 엔티티 만들기
        Post post = PostMapper.createPostRequestDtotoEntity(requestDto);
        //save
        postRepository.save(post);

        return PostMapper.entityToCreatePostresponseDto(post);
    }

    @Override
    public UpdatePostResponseDto updatePost(UpdatePostRequestDto requestDto) {
        return null;
    }
}
