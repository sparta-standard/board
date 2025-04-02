package io.sparta.board.application.dto.request;

import io.sparta.board.domain.model.Post;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateRequestDto {
    private String title;
    private String content;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }

    public boolean isNotValid() {
        // null, 빈 문자열, 공백으로 채워진 문자열이라면 true 를 반환하는 isBlank()
        // title 과 content 둘 다 값이 없다면 true 를 반환한다.
        return (this.title == null || this.title.isBlank()) && (this.content == null || this.content.isBlank());
    }
}
