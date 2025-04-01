package io.sparta.board.application.facade;

import io.sparta.board.application.usecase.PostService;
import io.sparta.board.presentation.dto.PostCreateRequestDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostFacadeImpl implements PostFacade {

    private final PostService postService;

    @Override
    public UUID createPost(PostCreateRequestDto requestDto) {
        return postService.createPost(requestDto.createPost());
    }
}
