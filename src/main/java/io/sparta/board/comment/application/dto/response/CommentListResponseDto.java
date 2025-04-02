package io.sparta.board.comment.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentListResponseDto {

    private String message;
    private int stateCode;
    private List<CommentResponseDto.CommentData> comments;
}