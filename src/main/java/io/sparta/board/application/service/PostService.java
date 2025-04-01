package io.sparta.board.application.service;

import io.sparta.board.application.dto.post.PostInternalDto;
import io.sparta.board.application.dto.post.PostResponseInternalDto;
import io.sparta.board.application.mapper.PostMapper;
import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;
import io.sparta.board.domain.service.CommentDomainService;
import io.sparta.board.domain.service.PostDomainService;
import io.sparta.board.infrastructure.exception.DeletedEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostDomainService postDomainService;

    private final CommentDomainService commentDomainService;

    @Transactional
    public PostResponseInternalDto createPost(PostInternalDto internalRequest) {

        Post post = PostMapper.toEntity(internalRequest);

        postDomainService.createPost(post);

        return PostMapper.toResponse(post);
    }

    @Transactional(readOnly = true)
    public PostResponseInternalDto findPostById(UUID postId, Pageable pageable) {

        Post post = postDomainService.findPostById(postId);

        if(post.getDeleted()) {
            throw new DeletedEntityException("삭제된 게시글입니다.");
        }

        Page<Comment> commentPage = commentDomainService.findAllByPost(post, pageable);

        return PostMapper.toResponseWithComments(post, commentPage);
    }

    @Transactional
    public PostResponseInternalDto updatePost(UUID postId, PostInternalDto request) {

        Post post = postDomainService.findPostById(postId);

        if(post.getDeleted()) {
            throw new DeletedEntityException("삭제된 게시글 입니다.");
        }

        post.update(request.getTitle(), request.getContent());

        postDomainService.updatePost(post);

        return PostMapper.toResponse(post);
    }

    @Transactional
    public PostResponseInternalDto deletePostById(UUID postId) {

        Post post = postDomainService.findPostById(postId);

        if(post.getDeleted()) {
            throw new DeletedEntityException("이미 삭제된 게시글 입니다.");
        }

        postDomainService.deletePostById(postId);

        return PostMapper.toResponse(post);
    }
}
