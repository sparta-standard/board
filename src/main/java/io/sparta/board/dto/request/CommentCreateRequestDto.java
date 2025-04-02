package io.sparta.board.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class CommentCreateRequestDto {

    private UUID postId;
    private String content;

}
