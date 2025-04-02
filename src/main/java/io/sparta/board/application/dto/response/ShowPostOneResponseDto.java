package io.sparta.board.application.dto.response;

import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowPostOneResponseDto {
    private UUID id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;
    private List<ShowCommentResponseDto> commentList = new ArrayList<>();

    public ShowPostOneResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        this.deleted = post.isDeleted();
        // *** this.commentList = post.getComments(); 이렇게 작성했더니 게시글과 댓글이 무한 참조되는 상황이 발생
        this.commentList = makeCommentList(post.getComments());
    }

    private List<ShowCommentResponseDto> makeCommentList(List<Comment> comments) {
        for (Comment comment : comments) this.commentList.add(new ShowCommentResponseDto(comment));
        return this.commentList;
    }

    @Getter
    @Setter
    private static class ShowCommentResponseDto {
        private UUID id;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private boolean deleted;

        private ShowCommentResponseDto(Comment comment) {
            this.id = comment.getId();
            this.content = comment.getContent();
            this.createdAt = comment.getCreatedAt();
            this.updatedAt = comment.getUpdatedAt();
            this.deleted = comment.isDeleted();
        }
    }

}
