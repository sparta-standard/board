package io.sparta.board.application.service;

import io.sparta.board.application.dto.post.CreatePostInternalDto;
import io.sparta.board.application.dto.post.PostResponseInternalDto;
import io.sparta.board.application.mapper.PostMapper;
import io.sparta.board.domain.model.Post;
import io.sparta.board.domain.service.PostDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostDomainService postDomainService;

    @Transactional
    public PostResponseInternalDto createPost(CreatePostInternalDto internalRequest) {

        Post post = PostMapper.toEntity(internalRequest);

        postDomainService.createPost(post);

        return PostMapper.toResponse(post);
    }

    @Transactional(readOnly = true)
    public Post findPostById(UUID postId) {

        return postDomainService.findPostById(postId);
    }
}
