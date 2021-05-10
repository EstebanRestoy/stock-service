package com.stock.stock.exception;

public class InvalidAPIKeyException extends RuntimeException {
    public InvalidAPIKeyException(String message) {
        super(message);
    }
}
