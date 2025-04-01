package io.sparta.board.presentation.controller;

import io.sparta.board.application.dto.comment.CommentResponseInternalDto;
import io.sparta.board.application.dto.comment.CommentRequestInternalDto;
import io.sparta.board.application.dto.post.PostInternalDto;
import io.sparta.board.application.dto.post.PostResponseInternalDto;
import io.sparta.board.application.service.CommentService;
import io.sparta.board.application.service.PostService;
import io.sparta.board.presentation.dto.BaseResponse;
import io.sparta.board.presentation.dto.Pagination;
import io.sparta.board.presentation.dto.comment.CommentResponseDto;
import io.sparta.board.presentation.dto.comment.CommentRequestDto;
import io.sparta.board.presentation.dto.post.PostRequestDto;
import io.sparta.board.presentation.dto.post.PostResponseDto;
import io.sparta.board.presentation.mapper.CommentDtoMapper;
import io.sparta.board.presentation.mapper.PostDtoMapper;
import io.sparta.board.presentation.util.PageUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @PostMapping("")
    public BaseResponse<PostResponseDto> createPost(@Valid @RequestBody PostRequestDto request) {

        PostInternalDto internalDto = PostDtoMapper.toInternalDto(request);

        PostResponseInternalDto response = postService.createPost(internalDto);

        return BaseResponse.SUCCESS(PostDtoMapper.toResponse(response));
    }

    @GetMapping("/{postId}")
    public BaseResponse<PostResponseDto> getPostByIdWithComments(@PathVariable UUID postId, Pageable pageable) {

        int validatedPageSize = PageUtils.getValidatedPage(pageable.getPageSize());

        Pageable page = PageRequest.of(pageable.getPageNumber(), validatedPageSize, pageable.getSort());

        PostResponseInternalDto response = postService.findPostById(postId, page);

        return BaseResponse.SUCCESS(PostDtoMapper.toResponseWithComments(response), Pagination.of(response.getComments()));
    }

    @PutMapping("/{postId}")
    public BaseResponse<PostResponseDto> updatePost(@PathVariable UUID postId, @Valid @RequestBody PostRequestDto request) {

        PostInternalDto internalDto = PostDtoMapper.toInternalDto(request);

        PostResponseInternalDto response = postService.updatePost(postId, internalDto);

        return BaseResponse.SUCCESS(PostDtoMapper.toResponse(response));
    }

    @DeleteMapping("/{postId}")
    public BaseResponse<PostResponseDto> deletePost(@PathVariable UUID postId) {

        PostResponseInternalDto response = postService.deletePostById(postId);

        return BaseResponse.SUCCESS(PostDtoMapper.toResponse(response));
    }
    // ------------------- Comment ------------------- //

    @PostMapping("/{postId}/comments")
    public BaseResponse<CommentResponseDto> createComment(@PathVariable UUID postId, @Valid @RequestBody CommentRequestDto request) {

        CommentRequestInternalDto internalDto = CommentDtoMapper.toInternalDto(request);

        CommentResponseInternalDto response = commentService.createComment(postId, internalDto);

        return BaseResponse.SUCCESS(CommentDtoMapper.toResponse(response));
    }

    @PutMapping("/comments/{commentId}")
    public BaseResponse<CommentResponseDto> updateComment(@PathVariable UUID commentId, @Valid @RequestBody CommentRequestDto request) {

        CommentRequestInternalDto internalDto = CommentDtoMapper.toInternalDto(request);

        CommentResponseInternalDto response = commentService.updateComment(commentId, internalDto);

        return BaseResponse.SUCCESS(CommentDtoMapper.toResponse(response));
    }

    @DeleteMapping("/comments/{commentId}")
    public BaseResponse<CommentResponseDto> deleteComment(@PathVariable UUID commentId) {

        CommentResponseInternalDto response = commentService.deleteCommentById(commentId);

        return BaseResponse.SUCCESS(CommentDtoMapper.toResponse(response));
    }
}
