package io.sparta.board.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public class PostUpdateRequestDto {

  @NotBlank(message = "제목을 입력해 주세요.")
  private String title;

  @NotBlank(message = "내용을 입력해 주세요.")
  private String content;
}
