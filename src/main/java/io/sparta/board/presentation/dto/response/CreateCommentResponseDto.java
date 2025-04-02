package io.sparta.board.presentation.dto.response;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateCommentResponseDto {

    private UUID commentId;
    private String content;


}
