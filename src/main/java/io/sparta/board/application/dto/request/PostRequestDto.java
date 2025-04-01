package io.sparta.board.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class PostRequestDto {

    @NotBlank(message = "제목은 필수입니다.")
    private String postTitle;

    @NotBlank(message = "내용은 필수입니다.")
    private String postContent;
}