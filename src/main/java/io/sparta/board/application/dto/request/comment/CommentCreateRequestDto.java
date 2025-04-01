package io.sparta.board.application.dto.request.comment;

import io.sparta.board.domain.entity.Comment;
import io.sparta.board.domain.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentCreateRequestDto {
    private String content;

    public Comment toEntity(Post post) {
        return Comment.create(content, post);
    }
}
