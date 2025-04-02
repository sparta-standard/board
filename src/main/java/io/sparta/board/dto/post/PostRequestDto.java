package io.sparta.board.dto.post;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class PostRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
