package io.sparta.board.service;

import io.sparta.board.dto.PostCreateRequestDto;
import io.sparta.board.dto.PostCreateResponseDto;
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
    public PostCreateResponseDto createPost(PostCreateRequestDto requestDto){
        Post post = new Post(requestDto.getTitle(),requestDto.getContent());

        Post savedPost = postRepository.save(post);
        return new PostCreateResponseDto(savedPost);
    }

    @Transactional(readOnly = true)
    public PostCreateResponseDto getPostById(UUID id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다."));
        return new PostCreateResponseDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostCreateResponseDto> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(PostCreateResponseDto::new)
                .toList();
    }

}
