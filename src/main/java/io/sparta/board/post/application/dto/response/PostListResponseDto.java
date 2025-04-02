package io.sparta.board.post.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostListResponseDto {
    private String message;
    private int stateCode;
    private List<PostResponseDto.PostData> posts;
}