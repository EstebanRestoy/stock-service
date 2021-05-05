package com.stock.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ValidationService implements IValidationService{


    @Autowired
    private Environment env;

    @Override
    public boolean isValidISBN(String isbn) {
        return isbn.matches("[0-9]{12,13}");
    }

    @Override
    public boolean isValidKey(String key) {
        if(key == null){
            return false;
        }
        return key.equals(env.getProperty("api.key"));
    }

    @Override
    public boolean isValidStock(String stock) {
        int stockInteger = 0;
        try {
            stockInteger =Integer.parseInt(stock);
        }catch(Exception e) {
             return false;
        }
        return stockInteger >= 0;
    }

}
