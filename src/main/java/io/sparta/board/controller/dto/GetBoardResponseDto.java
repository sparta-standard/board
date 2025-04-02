package io.sparta.board.controller.dto;

import io.sparta.board.repository.entity.Comment;
import lombok.Getter;


import java.util.List;

@Getter
public class GetBoardResponseDto {
    String title;
    List<Comment> comments;

    public GetBoardResponseDto(String title, List<Comment> comments) {
        this.title = title;
        this.comments = comments;
    }
}
