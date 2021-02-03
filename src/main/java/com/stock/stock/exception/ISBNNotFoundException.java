package com.stock.stock.exception;

public class ISBNNotFoundException extends RuntimeException {
    public ISBNNotFoundException(String message) {
        super(message);
    }
}
