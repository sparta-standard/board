package io.sparta.board.presentation.dto.request;

import io.sparta.board.model.entity.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public class PostCreateRequestDto {

    @NotBlank(message = "제목을 입력해주세요.")
    @Size(min = 10, max = 100, message = "제목은 10자 이상 100자 이하로 입력해주세요.")
    private final String title;
    @NotBlank(message = "내용을 입력해주세요.")
    @Size(min = 10, message = "내용은 10자 이상 입력해주세요.")
    private final String content;

    public Post createPost() {
        return Post.createPost(title, content);
    }
}
