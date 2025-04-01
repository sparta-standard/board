package io.sparta.board.presentation.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
public class Pagination {

    private Integer totalPages;

    private Long totalElements;

    private Integer currentPage;

    private Integer currentElements;

    public static <T> Pagination of(Page<T> contents){

        return Pagination.builder()
                .currentPage(contents.getNumber())
                .currentElements(contents.getNumberOfElements())
                .totalElements(contents.getTotalElements())
                .totalPages(contents.getTotalPages())
                .build();
    }
}
