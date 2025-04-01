package io.sparta.board.presentation.controller;

import io.sparta.board.application.dto.comment.CommentResponseInternalDto;
import io.sparta.board.application.dto.comment.CreateCommentRequestInternalDto;
import io.sparta.board.application.dto.post.CreatePostInternalDto;
import io.sparta.board.application.dto.post.PostResponseInternalDto;
import io.sparta.board.application.service.CommentService;
import io.sparta.board.application.service.PostService;
import io.sparta.board.presentation.dto.BaseResponse;
import io.sparta.board.presentation.dto.Pagination;
import io.sparta.board.presentation.dto.comment.CommentResponseDto;
import io.sparta.board.presentation.dto.comment.CreateCommentRequestDto;
import io.sparta.board.presentation.dto.post.CreatePostRequestDto;
import io.sparta.board.presentation.dto.post.PostResponseDto;
import io.sparta.board.presentation.mapper.CommentDtoMapper;
import io.sparta.board.presentation.mapper.PostDtoMapper;
import io.sparta.board.presentation.util.PageUtils;
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
    public BaseResponse<PostResponseDto> createPost(@RequestBody CreatePostRequestDto request) {

        CreatePostInternalDto internalRequest = PostDtoMapper.toInternalDto(request);

        PostResponseInternalDto response = postService.createPost(internalRequest);

        return BaseResponse.SUCCESS(PostDtoMapper.toResponse(response));
    }

    @GetMapping("/{postId}")
    public BaseResponse<PostResponseDto> getPostByIdWithComments(@PathVariable UUID postId, Pageable pageable) {

        int validatedPageSize = PageUtils.getValidatedPage(pageable.getPageSize());

        Pageable page = PageRequest.of(pageable.getPageNumber(), validatedPageSize, pageable.getSort());

        PostResponseInternalDto response = postService.findPostById(postId, page);

        return BaseResponse.SUCCESS(PostDtoMapper.toResponseWithComments(response), Pagination.of(response.getComments()));
    }

    // ------------------- Comment ------------------- //

    @PostMapping("/{postId}/comments")
    public BaseResponse<CommentResponseDto> createComment(@PathVariable UUID postId, @RequestBody CreateCommentRequestDto request) {

        CreateCommentRequestInternalDto internalDto = CommentDtoMapper.toInternalDto(request);

        CommentResponseInternalDto response = commentService.createComment(postId, internalDto);

        return BaseResponse.SUCCESS(CommentDtoMapper.toResponse(response));
    }
}
