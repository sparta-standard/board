package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.PostCreateRequestDto;
import io.sparta.board.application.dto.request.PostUpdateRequestDto;
import io.sparta.board.application.dto.response.PostGetResponseDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostService {
    public void createPost(PostCreateRequestDto dto) {
    }

    public void updatePost(UUID id, PostUpdateRequestDto dto) {
    }

    public void deletePost(UUID id) {
    }

    public PostGetResponseDto getPost(UUID id) {
        return null;
    }
}
