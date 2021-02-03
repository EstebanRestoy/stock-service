package com.stock.stock.service;

public interface IStockService {
    int getStockByISBN(String isbn) throws Exception;

    void editStock(String isbn, int quantity,String action) throws Exception;

    boolean isValidISBN(String isbn);
}

