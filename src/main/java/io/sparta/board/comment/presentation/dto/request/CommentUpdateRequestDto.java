package io.sparta.board.comment.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sparta.board.comment.model.entity.Comment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public class CommentUpdateRequestDto {

    @NotBlank(message = "수정할 내용을 입력해주세요")
    @Size(min = 10, message = "내용은 10자 이상 입력해주세요.")
    @JsonProperty
    private final String content;

    public void updateComment(Comment comment) {
        comment.updateComment(content);
    }
}
