package io.sparta.board.application.service;

import io.sparta.board.exception.CustomException;
import io.sparta.board.exception.ExceptionCode;
import io.sparta.board.model.entity.Comment;
import io.sparta.board.model.entity.Post;
import io.sparta.board.model.repository.CommentRepository;
import io.sparta.board.model.repository.PostRepository;
import io.sparta.board.presentation.dto.CommentDto;
import io.sparta.board.presentation.dto.response.CreatePostResponseDto;
import io.sparta.board.presentation.dto.request.CreatePostRequestDto;
import io.sparta.board.presentation.dto.request.UpdatePostRequestDto;
import io.sparta.board.presentation.dto.response.GetPostResponseDto;
import io.sparta.board.presentation.dto.response.UpdatePostResponseDto;
import io.sparta.board.presentation.mapper.CommentMapper;
import io.sparta.board.presentation.mapper.PostMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public CreatePostResponseDto createPost(CreatePostRequestDto requestDto) {
        //dto 로 엔티티 만들기
        Post post = PostMapper.createPostRequestDtotoEntity(requestDto);
        //save
        postRepository.save(post);
        return PostMapper.entityToCreatePostresponseDto(post);
    }

    @Override
    public UpdatePostResponseDto updatePost(UUID postId, UpdatePostRequestDto requestDto) {
        //id로 포스트 값 찾기
        Post post = postRepository.findById(postId).orElseThrow(() -> new CustomException(
                ExceptionCode.POST_NOT_FOUND));
        post.update(requestDto);
        UpdatePostResponseDto responseDto = PostMapper.entityToUpdatePostResponseDto(post);
        return responseDto;
    }

    @Override
    public Void deletePost(UUID postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new CustomException(
                ExceptionCode.POST_NOT_FOUND));
        post.softDelete();
        return null;
    }

    @Override
    public GetPostResponseDto getPost(UUID postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new CustomException(
                ExceptionCode.POST_NOT_FOUND));

        List<Comment> comments = commentRepository.findByPost(post);

        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            CommentDto commentDto = CommentMapper.entityToCommentDto(comment);
            commentDtos.add(commentDto);
        }
        return PostMapper.entityToGetPostResponseDto(post, commentDtos);
    }


}
