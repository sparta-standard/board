package io.sparta.board.domain.post.service;

import io.sparta.board.domain.post.dto.request.PostCreateRequestDto;
import io.sparta.board.domain.post.dto.request.PostUpdateRequestDto;
import io.sparta.board.domain.post.dto.response.GetPostResponseDto;
import io.sparta.board.domain.post.dto.response.PostResponseDto;
import io.sparta.board.domain.post.dto.response.PostUpdateResponse;
import io.sparta.board.model.comment.entity.Comment;
import io.sparta.board.model.post.entity.Post;
import io.sparta.board.model.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServcie {

    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto request){

            Boolean existTitle = postRepository.existsByTitle(request.getTitle());
            if(existTitle == true){
                log.info("Post already exists with title {}", request.getTitle());
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
        Post post = postRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글 없음"));

        List<String> comments = new ArrayList<>();
        for(Comment comment : post.getComments()){
            comments.add(comment.getContent());
        }

        return GetPostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .comments(comments)
                .build();
    }


    public PostUpdateResponse updatePost(UUID id, PostUpdateRequestDto request) {

        Post existPost = postRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글 없음"));

        existPost.updatePost(request.getTitle(), request.getContent());

        Post savePost = postRepository.save(existPost);

        return PostUpdateResponse.builder()
                .id(savePost.getId())
                .title(savePost.getTitle())
                .content(savePost.getContent())
                .build();

    }

    public void deletePost(UUID id) {

        Post existPost = postRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글 없음"));

        existPost.setDeleted(true);

        postRepository.save(existPost);

    }
}
