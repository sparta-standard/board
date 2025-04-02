package io.sparta.board.service;

import io.sparta.board.dto.request.PostCreateRequestDto;
import io.sparta.board.dto.request.PostUpdateRequestDto;
import io.sparta.board.dto.response.PostDetailResponseDto;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostDetailResponseDto getPost(UUID id) {
        Post post = postRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글 없음"));
        return new PostDetailResponseDto(post);
    }

    public List<PostDetailResponseDto> getAllPosts() {
        List<Post> posts = postRepository.findAllByDeletedFalse();
        return posts.stream()
                .map(PostDetailResponseDto::new)
                .toList();
    }

    @Transactional
    public PostDetailResponseDto createPost(PostCreateRequestDto dto) {
        Post post = Post.toEntity(dto);
        Post saved = postRepository.save(post);
        return new PostDetailResponseDto(saved);
    }

    @Transactional
    public PostDetailResponseDto updatePost(UUID id, PostUpdateRequestDto dto) {
        Post post = postRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글 없음"));

        post.update(dto.getTitle(), dto.getContent()); // 엔티티 메서드 활용
        return new PostDetailResponseDto(post);
    }

    @Transactional
    public void deletePost(UUID id) {
        Post post = postRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 게시물"));
        post.softDelete();
    }
}