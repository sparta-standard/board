package io.sparta.board.application.dto.response.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentCreateResponseDto {
    private UUID id;
    private String content;
}
