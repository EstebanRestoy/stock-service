package com.stock.stock.controller;

import com.stock.stock.exception.*;

import com.stock.stock.entity.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ISBNNotFoundException.class)
    public final ResponseEntity<ApiException> handleISBNNotFound(ISBNNotFoundException ex, WebRequest request) {
        ApiException e = new ApiException(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidAPIKeyException.class)
    public final ResponseEntity<ApiException> handleInvalidAPIKey(InvalidAPIKeyException ex, WebRequest request) {
        ApiException e = new ApiException(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ISBNNotValidException.class)
    public final ResponseEntity<ApiException> handleISBNNotValid(ISBNNotValidException ex, WebRequest request) {
        ApiException e = new ApiException(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongFomatQuantityException.class)
    public final ResponseEntity<ApiException> handleWrongFomatQuantityException(WrongFomatQuantityException ex, WebRequest request) {
        ApiException e = new ApiException(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotEnoughQuantityException.class)
    public final ResponseEntity<ApiException> handleWrongFomatQuantityException(NotEnoughQuantityException ex, WebRequest request) {
        ApiException e = new ApiException(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}