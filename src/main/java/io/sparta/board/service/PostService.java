package io.sparta.board.service;

import io.sparta.board.dto.CommentResponseDto;
import io.sparta.board.dto.PostRequestDto;
import io.sparta.board.dto.PostResponseDto;
import io.sparta.board.entity.Comment;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = new Post();
        post.setTitle(requestDto.getTitle());
        post.setContent(requestDto.getContent());
        Post savedPost = postRepository.save(post);
        return toResponseDto(savedPost);
    }

    public PostResponseDto updatePost(UUID id, PostRequestDto requestDto) {
        Post post = postRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다."));
        post.setTitle(requestDto.getTitle());
        post.setContent(requestDto.getContent());
        Post updatedPost = postRepository.save(post);
        return toResponseDto(updatedPost);
    }

    public void deletePost(UUID id) {
        Post post = postRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다."));

        post.setDeleted(true);
        postRepository.save(post);
    }

    public PostResponseDto getPostById(UUID id) {
        Post post = postRepository.findByIdAndDeletedFalse(id).orElse(null);
        return toResponseDto(post);
    }

    private CommentResponseDto toCommentResponseDto(Comment comment) {
        return new CommentResponseDto(
                comment.getId(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }

    private PostResponseDto toResponseDto(Post post) {
        List<CommentResponseDto> comments = List.of();

        if (post != null && post.getComments() != null) {
            comments = post.getComments().stream()
                    .filter(comment -> !comment.isDeleted())
                    .map(this::toCommentResponseDto)
                    .collect(Collectors.toList());
        }

        return new PostResponseDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                comments);
    }
}
