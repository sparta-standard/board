package io.sparta.board.post.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRequestDto {

    @NotBlank(message = "제목은 필수입니다.")
    private String postTitle;

    @NotBlank(message = "내용은 필수입니다.")
    private String postContent;
}