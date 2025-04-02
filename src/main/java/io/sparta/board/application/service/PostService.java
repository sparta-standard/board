package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.PostRequestDto;
import io.sparta.board.application.dto.response.PostUpdateResponseDto;
import io.sparta.board.domain.model.Post;
import io.sparta.board.infastructure.JpaPostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final JpaPostRepository postRepository;


    public Long createPost(PostRequestDto requestDto) {
        Post post = postRepository.save(requestDto.createPost());
        return post.getId();
    }

    public PostUpdateResponseDto modifyPost(Long id, PostRequestDto requestDto) {
        Post post = findPostById(id);
        post.updatePost(requestDto);
        return PostUpdateResponseDto.from(post);
    }

    public Post findPostById(Long id) {
        return postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 게시글입니다."));
    }


}
