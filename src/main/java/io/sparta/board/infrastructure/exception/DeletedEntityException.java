package io.sparta.board.infrastructure.exception;

public class DeletedEntityException extends RuntimeException {
    public DeletedEntityException(String message) {
        super(message);
    }
}
