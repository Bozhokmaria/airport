package com.solvd.airport.exception;

public class WrongFormatException extends RuntimeException {

    public WrongFormatException() {
        super("Wrong format");
    }

    public WrongFormatException(String message) {
        super(message);
    }
}
