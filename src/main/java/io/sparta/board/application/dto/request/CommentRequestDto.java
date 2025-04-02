package io.sparta.board.application.dto.request;

import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;

public record CommentRequestDto(
        String content,
        Long postId
) {
    public Comment createComment(Post post) {
        return Comment.builder()
                .content(content)
                .post(post)
                .build();
    }
}
