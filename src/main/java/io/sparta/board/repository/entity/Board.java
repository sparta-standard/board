package io.sparta.board.repository.entity;

import io.sparta.board.controller.dto.CreateBoardRequestDto;
import io.sparta.board.controller.dto.UpdateBoardRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board extends BaseEntity {
    @UuidGenerator
    @Id
    private UUID id;

    @Column
    private String title;

    @Column
    private String content;

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
