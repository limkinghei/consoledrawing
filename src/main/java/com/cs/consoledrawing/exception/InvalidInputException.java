package com.cs.consoledrawing.exception;

public class InvalidInputException extends Exception {

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, Throwable th) {
        super(message, th);
    }

}
