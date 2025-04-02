package io.sparta.board.post.application.service;

import io.sparta.board.post.application.dto.request.PostRequestDto;
import io.sparta.board.post.application.dto.response.PostListResponseDto;
import io.sparta.board.post.application.dto.response.PostResponseDto;
import io.sparta.board.post.application.mapper.PostMapper;
import io.sparta.board.post.domain.entity.Post;
import io.sparta.board.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto createPost(PostRequestDto dto) {
        Post post = PostMapper.toEntity(dto);
        Post savedPost = postRepository.save(post);

        return PostResponseDto.builder()
                .message("게시글이 생성되었습니다.")
                .stateCode(201)
                .post(PostMapper.toPostData(savedPost))
                .build();
    }

    @Transactional
    public PostListResponseDto getAllPosts() {
        List<PostResponseDto.PostData> postList = postRepository.findAll().stream()
                .map(PostMapper::toPostData)
                .toList();

        return PostListResponseDto.builder()
                .message("전체 게시글이 조회되었습니다.")
                .stateCode(200)
                .posts(postList)
                .build();
    }

    @Transactional
    public PostResponseDto getPostById(UUID postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        return PostResponseDto.builder()
                .message("게시글이 조회되었습니다.")
                .stateCode(200)
                .post(PostMapper.toPostData(post))
                .build();
    }

    @Transactional
    public PostResponseDto updatePost(UUID postId, PostRequestDto dto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        post.update(dto.getPostTitle(), dto.getPostContent());

        return PostResponseDto.builder()
                .message("게시글이 수정되었습니다.")
                .stateCode(200)
                .post(PostMapper.toPostData(post))
                .build();
    }
}