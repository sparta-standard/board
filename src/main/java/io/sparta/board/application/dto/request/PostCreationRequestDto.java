package io.sparta.board.application.dto.request;

import io.sparta.board.domain.model.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PostCreationRequestDto {
    @NotBlank(message = "제목 입력은 필수입니다.")
    private String title;
    @NotBlank(message = "내용 입력은 필수입니다.")
    private String content;

    public Post toEntity() {
        return Post.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}
