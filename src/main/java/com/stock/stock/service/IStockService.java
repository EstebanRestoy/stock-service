package com.stock.stock.service;

import com.stock.stock.entity.Book;

import java.util.List;

public interface IStockService {
    int getStockByISBN(String isbn) throws Exception;

    void editStock(String isbn, int quantity,String action) throws Exception;

    boolean isValidISBN(String isbn);

    List<Book> getAllBooks() ;

}

