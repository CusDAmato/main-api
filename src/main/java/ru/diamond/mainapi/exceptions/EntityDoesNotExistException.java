package ru.diamond.mainapi.exceptions;

import org.springframework.http.HttpStatus;

public class EntityDoesNotExistException extends BusinessException {
    public EntityDoesNotExistException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
