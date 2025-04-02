package io.sparta.board.post.presentation.dto.request;

import io.sparta.board.post.model.entity.Post;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public class PostUpdateRequestDto {

    @Size(min = 10, max = 100, message = "제목은 10자 이상 100자 이하로 입력해주세요.")
    private final String title;

    @Size(min = 10, message = "내용은 10자 이상 입력해주세요.")
    private final String content;

    public void updatePost(Post post) {
        post.updatePost(title, content);
    }
}
