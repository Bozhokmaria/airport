package com.solvd.airport.exception;

public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException() {
        super("Already Exists");
    }

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
