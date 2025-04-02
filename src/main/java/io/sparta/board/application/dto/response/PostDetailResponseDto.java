package io.sparta.board.application.dto.response;

import java.sql.Timestamp;
import java.util.UUID;

public class PostDetailResponseDto {

  private UUID id;
  private String title;
  private String content;
  private Timestamp createdAt;
  private Timestamp updatedAt;
}
