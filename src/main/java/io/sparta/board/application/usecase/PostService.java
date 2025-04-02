package io.sparta.board.application.usecase;

import io.sparta.board.model.entity.Post;
import java.util.UUID;

public interface PostService {

    Post createPost(Post post);

    Post getPost(UUID postId);
}
