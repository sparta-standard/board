package io.sparta.board.service;

import io.sparta.board.dto.request.PostCreateRequestDto;
import io.sparta.board.dto.response.PostResponseDto;
import io.sparta.board.dto.request.PostUpdateRequestDto;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.PostRepository;
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
    public PostResponseDto createPost(PostCreateRequestDto requestDto){
        Post post = new Post(requestDto.getTitle(),requestDto.getContent());

        Post savedPost = postRepository.save(post);
        return new PostResponseDto(savedPost);
    }

    @Transactional(readOnly = true)
    public PostResponseDto getPostById(UUID id){
        Post post = postRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new IllegalArgumentException("이미 삭제되었거나 존재하지 않는 게시글입니다."));
        return new PostResponseDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> getAllPosts(){
        List<Post> posts = postRepository.findByDeletedFalse();
        return posts.stream()
                .map(PostResponseDto::new)
                .toList();
    }

    @Transactional
    public PostResponseDto updatePost(UUID id, PostUpdateRequestDto requestDto){
        Post post = postRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new IllegalArgumentException("이미 삭제되었거나 존재하지 않는 게시글입니다."));

        post.update(requestDto.getTitle(),requestDto.getContent());

        return new PostResponseDto(post);
    }

    @Transactional
    public void deletePost(UUID id){
        Post post = postRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new IllegalArgumentException("이미 삭제되었거나 존재하지 않는 게시글입니다."));

        post.softDelete();

    }

}
