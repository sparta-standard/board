package io.sparta.board.repository.entity;

import io.sparta.board.controller.dto.CreateBoardRequestDto;
import io.sparta.board.controller.dto.UpdateBoardRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Board extends BaseEntity {
    @UuidGenerator
    @Id
    private UUID id;

    private String title;

    private String content;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    public static Board createBoard(CreateBoardRequestDto createBoardRequestDto) {
        Board board = new Board();
        board.title = createBoardRequestDto.getTitle();
        board.content = createBoardRequestDto.getContent();
        return board;
    }

    public static void updateBoard(Board board, UpdateBoardRequestDto updateBoardRequestDto) {
        if (updateBoardRequestDto.getTitle() != null) {board.title = updateBoardRequestDto.getTitle();}
        if (updateBoardRequestDto.getContent() != null) {board.content = updateBoardRequestDto.getContent();}
    }
}
