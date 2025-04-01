package io.sparta.board.domain.post.service;

import io.sparta.board.domain.post.dto.request.PostCreateRequestDto;
import io.sparta.board.domain.post.dto.response.GetPostResponseDto;
import io.sparta.board.domain.post.dto.response.PostResponseDto;
import io.sparta.board.model.post.entity.Post;
import io.sparta.board.model.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServcie {

    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto request){

            Post existTitle = postRepository.existsByTitle(request.getTitle());
            if(existTitle != null){
                throw new IllegalArgumentException("이미 존재하는 제목입니다.");
            }

            Post post = Post.builder()
                    .title(request.getTitle())
                    .content(request.getContent())
                    .build();


            Post savePost = postRepository.save(post);

        return PostResponseDto.builder()
                .id(savePost.getId())
                .title(savePost.getTitle())
                .build();
    }

    public GetPostResponseDto getPost(UUID id) {
        Post post = postRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글 없음"));


        return GetPostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .comments(post.getComments().toString())
                .build();
    }




}
