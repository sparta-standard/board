package io.sparta.board.service;


import io.sparta.board.dto.CommentResponseDto;
import io.sparta.board.dto.PostRequestDto;
import io.sparta.board.dto.PostResponseDto;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.CommentRepository;
import io.sparta.board.repository.PostRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;
  private final CommentRepository commentRepository;

  @Transactional
  public UUID createPost(PostRequestDto requestDto){
    Post post = Post.builder().title(requestDto.getTitle()).content(requestDto.getContent()).build();

    postRepository.save(post);
    return post.getId();
  }

  @Transactional(readOnly = true)
  public PostResponseDto getPost(UUID postId) {
    Post post = postRepository.findByIdAndDeletedFalse(postId)
        .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않거나 삭제되었습니다."));

    List<CommentResponseDto> commentDtos = commentRepository.findByPostAndDeletedFalse(post).stream()
        .map(CommentResponseDto::fromEntity)
        .collect(Collectors.toList());

    return PostResponseDto.builder()
        .id(post.getId())
        .title(post.getTitle())
        .content(post.getContent())
        .createdAt(post.getCreatedAt()) // ✅ 오타 수정
        .updatedAt(post.getUpdatedAt())
        .comments(commentDtos)
        .build();
  }
  @Transactional
  public void updatePost(UUID postId, PostRequestDto requestDto)  {
    Post post = postRepository.findByIdAndDeletedFalse(postId)
        .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않거나 삭제되었습니다."));

    post.update(requestDto.getTitle(), requestDto.getContent());
  }

  @Transactional
  public void deletePost(UUID postId) {
    Post post = postRepository.findByIdAndDeletedFalse(postId)
        .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않거나 삭제되었습니다."));

        post.softDelete();
  }
}
