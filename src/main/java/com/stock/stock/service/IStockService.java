package com.stock.stock.service;

import com.stock.stock.entity.Book;
import com.stock.stock.exception.ISBNNotValidException;
import com.stock.stock.exception.WrongFomatQuantityException;

import java.util.List;

public interface IStockService {
    int getStockByISBN(String isbn) throws Exception;

    void editStock(String isbn, String quantity, String action) throws Exception, ISBNNotValidException, WrongFomatQuantityException;

    boolean isValidISBN(String isbn);

    List<Book> getAllBooks() ;

}

