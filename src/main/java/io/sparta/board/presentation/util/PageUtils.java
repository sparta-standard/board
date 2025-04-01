package io.sparta.board.presentation.util;

import java.util.Set;

public class PageUtils {

    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final Set<Integer> ALLOWED_PAGE_SIZES = Set.of(10, 30, 50);

    public static Integer getValidatedPage(int requestSize) {

        if(ALLOWED_PAGE_SIZES.contains(requestSize)){

            return requestSize;
        }

        return DEFAULT_PAGE_SIZE;
    }
}
