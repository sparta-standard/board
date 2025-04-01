package io.sparta.board.presentation.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CommentRequestDto {

    @NotBlank(message = "내용을 입력하세요.")
    @Size(min = 5, message = "최소 5글자 이상 입력하세요.")
    private String content;
}
