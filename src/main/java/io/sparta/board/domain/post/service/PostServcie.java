package io.sparta.board.domain.post.service;

import io.sparta.board.domain.post.dto.request.PostCreateRequestDto;
import io.sparta.board.domain.post.dto.response.PostResponseDto;
import io.sparta.board.model.post.entity.Post;
import io.sparta.board.model.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServcie {

    private final PostRepository postRepository;

    public PostResponseDto createPost(PostCreateRequestDto request){



            Post post = Post.builder()
                    .title(request.getTitle())
                    .content(request.getContent())
                    .build();


            Post savaPost = postRepository.save(post);

        return PostResponseDto.builder()
                .id(savaPost.getId())
                .title(savaPost.getTitle())
                .build();
    }
}
