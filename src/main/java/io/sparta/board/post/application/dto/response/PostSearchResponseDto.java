package io.sparta.board.post.application.dto.response;

import io.sparta.board.comment.application.dto.response.CommentSearchResponseDto;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
@Builder
public class PostSearchResponseDto {

    private UUID postId;
    private String title;
    private String content;
    private Page<CommentSearchResponseDto> commentPage;
}
