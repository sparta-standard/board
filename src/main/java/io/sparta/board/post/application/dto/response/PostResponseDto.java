package io.sparta.board.post.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    private String message;
    private int stateCode;
    private PostData post;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostData {
        private UUID postId;
        private String postTitle;
        private String postContent;
    }
}