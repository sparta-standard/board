package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.PostCreateRequestDto;
import io.sparta.board.application.dto.response.PostCreateResponseDto;
import io.sparta.board.domain.entity.Post;
import io.sparta.board.domain.repository.PostRepository;
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
}
