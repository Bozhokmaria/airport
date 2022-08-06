package com.solvd.airport.exception;

public class NoSuchElementException extends RuntimeException {

    public NoSuchElementException() {
        super("Such element not exists");
    }

    public NoSuchElementException(String message) {
        super(message);
    }
}
