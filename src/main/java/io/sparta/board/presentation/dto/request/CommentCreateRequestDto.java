package io.sparta.board.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sparta.board.model.entity.Comment;
import io.sparta.board.model.entity.Post;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public class CommentCreateRequestDto {

    @JsonProperty
    private final String content;

    public Comment createComment(Post post) {
        return Comment.createComment(content, post);
    }

}
