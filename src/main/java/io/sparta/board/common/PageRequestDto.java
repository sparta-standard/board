package io.sparta.board.common;

import java.util.List;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
public class PageRequestDto {
    private Integer page;
    private Integer size;
    private Pageable pageable;

    private static final List<Integer>  PAGE_SIZE = List.of(10, 30, 50);

    public PageRequestDto(Integer page, Integer size) {
        this.page = (page != null && page >= 0) ? page : 0;
        this.size = (size != null && PAGE_SIZE.contains(size)) ? size : 10;
        this.pageable = PageRequest.of(this.page, this.size,  Sort.by(Sort.Direction.DESC, "createdAt"));
    }

}
