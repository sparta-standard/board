package io.sparta.board.application.facade;

import io.sparta.board.presentation.dto.PostCreateRequestDto;
import java.util.UUID;

public interface PostFacade {
    UUID createPost(PostCreateRequestDto requestDto);
}
