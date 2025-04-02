package io.sparta.board.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CommentCreateRequestDto {

  @NotBlank(message = "댓글을 입력해 주세요.")
  private String content;
}
