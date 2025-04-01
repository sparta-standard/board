package io.sparta.board.post.service;

import io.sparta.board.comment.dto.CommentResponseDto;
import io.sparta.board.post.dto.PostRequestDto;
import io.sparta.board.post.dto.PostResponseDto;
import io.sparta.board.post.dto.PostUpdateRequestDto;
import io.sparta.board.post.entity.Post;
import io.sparta.board.comment.repository.CommentRepository;
import io.sparta.board.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 게시글 생성
    public PostResponseDto createPost(PostRequestDto requestDto) {

        Post post = new Post(requestDto);
        Post savedPost = postRepository.save(post);

        return new PostResponseDto(savedPost);
    }


}
