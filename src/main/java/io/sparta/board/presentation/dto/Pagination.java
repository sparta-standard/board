package io.sparta.board.presentation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pagination {

    private Integer totalPages;

    private Long totalElements;

    private Integer currentPage;

    private Integer currentElements;
}
