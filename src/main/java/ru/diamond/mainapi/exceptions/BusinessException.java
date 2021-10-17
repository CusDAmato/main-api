package ru.diamond.mainapi.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {
    private HttpStatus status;

    public BusinessException() {
        this.status = HttpStatus.BAD_REQUEST;
    }

    public BusinessException(HttpStatus status) {
        this.status = status;
    }

    public BusinessException(String message) {
        this(message, HttpStatus.BAD_REQUEST);
    }

    public BusinessException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public BusinessException(String message, Throwable cause) {
        this(message, cause, HttpStatus.BAD_REQUEST);
    }

    public BusinessException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
