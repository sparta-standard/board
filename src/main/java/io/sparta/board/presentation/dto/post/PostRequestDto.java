package io.sparta.board.presentation.dto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class PostRequestDto {

    @NotBlank(message = "제목을 입력하세요.")
    @Size(min = 5, message = "최소 5글자 이상 입력하세요.")
    String title;

    @NotBlank(message = "내용을 입력하세요.")
    @Size(min = 5, message = "최소 5글자 이상 입력하세요.")
    String content;
}
