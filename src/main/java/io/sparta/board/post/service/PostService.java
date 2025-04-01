package io.sparta.board.post.service;

import io.sparta.board.comment.dto.CommentResponseDto;
import io.sparta.board.post.dto.PostRequestDto;
import io.sparta.board.post.dto.PostResponseDto;
import io.sparta.board.post.entity.Post;
import io.sparta.board.comment.repository.CommentRepository;
import io.sparta.board.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    // 게시글 생성
    public PostResponseDto createPost(PostRequestDto requestDto) {

        Post post = new Post(requestDto);
        Post savedPost = postRepository.save(post);

        return new PostResponseDto(savedPost);
    }

    // 게시글 단건 조회
    public PostResponseDto getPostWithComments(UUID id, Pageable pageable) {

        Post post = postRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        // 페이징처리
        if (pageable.getPageSize() != 10 && pageable.getPageSize() != 30 && pageable.getPageSize() != 50) {
            pageable = PageRequest.of(
                    pageable.getPageNumber(),
                    10,
                    pageable.getSort()
            );
        }

        Page<CommentResponseDto> comments = commentRepository.findByPostIdAndDeletedFalse(id, pageable)
                .map(CommentResponseDto::new);

        return new PostResponseDto(post, comments);
    }


}
