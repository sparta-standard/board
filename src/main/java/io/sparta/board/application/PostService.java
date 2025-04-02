package io.sparta.board.application;

import io.sparta.board.domain.Post;
import io.sparta.board.infrastructure.PostRepository;
import io.sparta.board.presentaion.PostRequestDto;
import io.sparta.board.presentaion.PostResponseDto;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

  private final PostRepository postRepository;

  public PostResponseDto save(PostRequestDto postRequestDto) {

    Post post = new Post(
        postRequestDto.getTitle(),
        postRequestDto.getContent()
    );
    postRepository.save(post);
    return new PostResponseDto(post);
  }

  public PostResponseDto updatePost(UUID postid, PostRequestDto postRequestDto) {
    Post post = postRepository.findById(postid).orElse(null);
    post.update(postRequestDto.getTitle(), postRequestDto.getContent());

    postRepository.save(post);
    return new PostResponseDto(post);
  }
}
