package io.sparta.board.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBoardRequestDto {
    public String title;
    public String content;
}
