package io.sparta.board.presentation.dto;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentDto {

    private UUID commentId;
    private String content;


}
