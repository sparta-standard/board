package io.sparta.board.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static org.springframework.http.HttpStatus.*;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    /**
     * 공통
     */
    INVALID_INPUT_VALUE(0000, BAD_REQUEST.value(), "유효하지 않은 입력값입니다."),

    /**
     * 게시글
     */
    POST_NOT_FOUND(1000, NOT_FOUND.value(), "게시글이 존재하지 않습니다."),
    POST_ALREADY_DELETED(1000, BAD_REQUEST.value(), "이미 삭제된 게시글입니다."),

    /**
     * 댓글
     */
    COMMENT_NOT_FOUND(2000, NOT_FOUND.value(), "댓글이 존재하지 않습니다."),
    COMMENT_ALREADY_DELETED(2000, BAD_REQUEST.value(), "이미 삭제된 댓글입니다.");

    private final int code;
    private final int status;
    private final String message;
}
