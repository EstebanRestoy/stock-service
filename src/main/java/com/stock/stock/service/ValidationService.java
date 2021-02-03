package com.stock.stock.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationService implements IValidationService{

    @Override
    public boolean isValidISBN(String isbn) {
        return isbn.matches("[0-9]{12,13}");
    }

    @Override
    public boolean isValidStock(int stock) {
        return stock >= 0;
    }

}
