package io.sparta.board.application.dto.response;

import java.sql.Timestamp;
import java.util.UUID;
import lombok.Getter;

@Getter
public class PostUpdateResponseDto {

  private UUID id;
  private String title;
  private String content;
  private Timestamp updatedAt;
}
