package com.stock.stock.service;

public interface IValidationService {

     boolean isValidISBN(String isbn);

     boolean isValidKey(String key);

     boolean isValidStock(String stock);

}
