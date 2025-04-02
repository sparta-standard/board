package io.sparta.board.post.application.usecase;

import io.sparta.board.post.model.entity.Post;
import io.sparta.board.post.presentation.dto.request.PostUpdateRequestDto;
import java.util.UUID;

public interface PostService {

    Post createPost(Post post);

    Post getPost(UUID postId);

    void updatePost(Post post, PostUpdateRequestDto requestDto);

    void deletePost(Post post);

    void isDeleted(Post post);
}
