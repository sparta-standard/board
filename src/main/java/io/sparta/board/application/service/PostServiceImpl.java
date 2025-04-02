package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.PostCreateRequestDto;
import io.sparta.board.application.dto.request.PostUpdateRequestDto;
import io.sparta.board.application.dto.response.PostCreateResponseDto;
import io.sparta.board.application.dto.response.PostUpdateResponseDto;
import io.sparta.board.domain.entity.Post;
import io.sparta.board.domain.repository.PostRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  @Override
  @Transactional
  public PostCreateResponseDto createPost(PostCreateRequestDto requestDto) {
    log.info("게시판 생성 서비스 연결 완료 - title: {} , content: {}", requestDto.getTitle(),
        requestDto.getContent());
    Post post = postRepository.save(
        Post.builder()
            .title(requestDto.getTitle())
            .content(requestDto.getContent())
            .deleted(false)
            .build()
    );
    return new PostCreateResponseDto(post);
  }

  @Override
  @Transactional
  public PostUpdateResponseDto updatePost(UUID id, PostUpdateRequestDto requestDto) {
    log.info("게시판 수정 서비스 연결 완료 - title: {} , content: {}", requestDto.getTitle(),
        requestDto.getContent());
    Post post = postRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당하는 게시물이 없습니다."));

    post.updateTitle(requestDto.getTitle());
    post.updateContent(requestDto.getContent());

    return new PostUpdateResponseDto(post);
  }

  @Override
  @Transactional
  public void deletePost(UUID id) {

    Post post = postRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당하는 게시물이 없습니다."));

    log.info("게시판 삭제 서비스 연결 완료 (삭제 전) - id: {}, deleted: {}", id, post.getDeleted());

    post.setDeleted(true);

    log.info("게시판 삭제 서비스 연결 완료 (삭제 후) - id: {}, deleted: {}", id, post.getDeleted());
  }
}
