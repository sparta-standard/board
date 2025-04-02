package io.sparta.board.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sparta.board.model.entity.Comment;
import io.sparta.board.model.entity.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public class CommentCreateRequestDto {

    @JsonProperty
    @NotBlank(message = "내용을 입력해주세요.")
    @Size(min = 10, message = "내용은 10자 이상 입력해주세요.")
    private final String content;

    public Comment createComment(Post post) {
        return Comment.createComment(content, post);
    }

}
