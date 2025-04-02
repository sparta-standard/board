package io.sparta.board.post.application.service;

i
import io.sparta.board.comment.domain.entity.Comment;
import io.sparta.board.comment.domain.repository.CommentRepository;
import io.sparta.board.common.exception.ErrorCode;
import io.sparta.board.common.exception.GlobalException;
import io.sparta.board.post.application.dto.request.PostRequestDto;
import io.sparta.board.post.application.dto.response.PostListResponseDto;
import io.sparta.board.post.application.dto.response.PostResponseDto;
import io.sparta.board.post.application.mapper.PostMapper;
import io.sparta.board.post.domain.entity.Post;
import io.sparta.board.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto createPost(PostRequestDto dto) {
        Post post = PostMapper.toEntity(dto);
        Post savedPost = postRepository.save(post);

        return PostResponseDto.builder()
                .message("게시글이 생성되었습니다.")
                .stateCode(201)
                .post(PostMapper.toPostData(savedPost))
                .build();
    }

    @Transactional
    public PostListResponseDto getAllPosts() {
        List<PostResponseDto.PostData> postList = postRepository.findAll().stream()
                .map(PostMapper::toPostData)
                .toList();

        return PostListResponseDto.builder()
                .message("전체 게시글이 조회되었습니다.")
                .stateCode(200)
                .posts(postList)
                .build();
    }

    @Transactional
    public PostResponseDto getPostById(UUID postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new GlobalException(ErrorCode.POST_NOT_FOUND));

        return PostResponseDto.builder()
                .message("게시글이 조회되었습니다.")
                .stateCode(200)
                .post(PostMapper.toPostData(post))
                .build();
    }

    @Transactional
    public PostResponseDto updatePost(UUID postId, PostRequestDto dto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new GlobalException(ErrorCode.POST_NOT_FOUND));

        post.update(dto.getPostTitle(), dto.getPostContent());

        return PostResponseDto.builder()
                .message("게시글이 수정되었습니다.")
                .stateCode(200)
                .post(PostMapper.toPostData(post))
                .build();
    }

    @Transactional
    public PostResponseDto deletePost(UUID postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new GlobalException(ErrorCode.POST_NOT_FOUND));

        post.softDelete();

        List<Comment> comments = commentRepository.findByPost(post);
        if (comments != null && comments.size() > 0) {
            for (int i = 0; i < comments.size(); i++) {
                Comment comment = comments.get(i);
                if (comment != null) {
                    comment.softDelete();
                }
            }
        }

        return PostResponseDto.builder()
                .message("게시글이 삭제되었습니다.")
                .stateCode(200)
                .build();
    }
}