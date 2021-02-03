package com.stock.stock.exception;

public class ISBNNotValidException extends RuntimeException {
    public ISBNNotValidException(String message) {
        super(message);
    }
}
