package io.sparta.board.infrastructure.exception;

import io.sparta.board.presentation.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DeletedEntityException.class )
    public BaseResponse<Void> handleDeletedEntityException(DeletedEntityException e) {

        return BaseResponse.FAIL(e.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public BaseResponse<Void> handleIllegalArgumentException(IllegalArgumentException e) {

        return BaseResponse.FAIL(e.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        return BaseResponse.FAIL(e.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

}
