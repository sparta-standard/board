package io.sparta.board.service;

import io.sparta.board.dto.PostRequestDto;
import io.sparta.board.dto.PostResponseDto;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 작성
    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        Post savePost = postRepository.save(post);
        return PostResponseDto.from(savePost);
    }

    // 수정
    @Transactional
    public PostResponseDto updatePost(UUID id, PostRequestDto requestDto) {
        Post post = findPost(id);
        post.updatePost(requestDto);
        return PostResponseDto.from(post);
    }

    // 삭제
    @Transactional
    public UUID deletePost(UUID id) {
        Post post = findPost(id);
        post.softDelete();
        return id;
    }

    // 전체 조회
    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAllByDeletedFalseOrderByCreatedAtDesc().stream().map(PostResponseDto::from).toList();
    }

    // 단건 조회
    public PostResponseDto getPost(UUID id) {
        Post post = findPost(id);
        return PostResponseDto.from(post);
    }

    private Post findPost(UUID id) {
        return postRepository.findByIdAndDeletedFalse(id).orElseThrow(() ->
                new EntityNotFoundException("해당 게시글이 존재하지 않습니다.")
        );
    }
}
