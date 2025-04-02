package io.sparta.board.application.usecase;

import io.sparta.board.model.entity.Post;
import io.sparta.board.presentation.dto.request.PostUpdateRequestDto;
import java.util.UUID;

public interface PostService {

    Post createPost(Post post);

    Post getPost(UUID postId);

    void updatePost(Post post, PostUpdateRequestDto requestDto);

    void deletePost(Post post);

    void isDeleted(Post post);
}
