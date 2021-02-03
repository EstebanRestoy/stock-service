package com.stock.stock.service;

import com.stock.stock.entity.Book;
import com.stock.stock.exception.ISBNNotFoundException;
import com.stock.stock.exception.ISBNNotValidException;
import com.stock.stock.repository.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService implements IStockService {

    @Autowired
    IStockRepository IStockRepository;

    @Autowired
    ValidationService validationService;

    @Override
    public int getStockByISBN(String isbn) throws Exception {
        if(!validationService.isValidISBN(isbn))
            throw new ISBNNotValidException("ISBN NOT VALID");

        if(IStockRepository.findById(isbn).isPresent()){
           return IStockRepository.findById(isbn).get().getQuantity();
        }

        throw new ISBNNotFoundException("ISBN DOESNT EXIST !");
    }

    @Override
    public boolean isValidISBN(String isbn) {
        return isbn.matches("[0-9]{12,13}");
    }

    @Override
    public void editStock(String isbn, int quantity, String action){
        if(!validationService.isValidISBN(isbn))
            throw new ISBNNotValidException("ISBN NOT VALID");

        if(!validationService.isValidStock(quantity))
            throw new ISBNNotValidException("QUANTITY NOT VALID");

        if(IStockRepository.findById(isbn).isPresent()){
            Book b = IStockRepository.findById(isbn).get();
            if(action.equals("add")){
                b.setQuantity( b.getQuantity() + quantity );
            }else{
                if(quantity > b.getQuantity()){
                    throw new ISBNNotValidException("QUANTITY NOT VALID STOCK AVAILABLE : " + b.getQuantity());
                }
                b.setQuantity( b.getQuantity() - quantity );
            }
            IStockRepository.save(b);
            return;
        }

        throw new ISBNNotFoundException("ISBN DOESNT EXIST !");
    }



}
