package io.sparta.board.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {
    private String message;
    private int stateCode;
    private CommentData comment;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommentData {
        private UUID commentId;
        private String commentContent;
    }
}