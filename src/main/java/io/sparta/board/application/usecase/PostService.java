package io.sparta.board.application.usecase;

import io.sparta.board.model.entity.Post;

public interface PostService {
    Post createPost(Post post);
}
