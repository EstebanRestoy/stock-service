package com.stock.stock.controller;

import com.stock.stock.entity.Book;
import com.stock.stock.exception.InvalidAPIKeyException;
import com.stock.stock.service.IStockService;
import com.stock.stock.service.IValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StockController {

    @Autowired
    IStockService stockService;

    @Autowired
    IValidationService validationService;

    @GetMapping("/books")
    public List<Book> books() {
        return stockService.getAllBooks();
    }

    @GetMapping("/stock/{isbn}")
    public Map<String, Object> getStock(@PathVariable("isbn") String isbn) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("isbn", isbn);
        map.put("quantity", stockService.getStockByISBN(isbn));
        return map;
    }

    @PostMapping(value="/stock/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addStock(@RequestBody Map<String, String> values) throws Exception, InvalidAPIKeyException {
        if(!validationService.isValidKey(values.get("key")))
            throw new InvalidAPIKeyException(values.get("key") + " is not a valid key !");

        stockService.editStock(values.get("isbn"), values.get("quantity"),"add");
        return "Quantity successfully updated !";
    }

    @PostMapping(value="/stock/remove", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String removeStock(@RequestBody Map<String, String> values) throws Exception, InvalidAPIKeyException {

        if(!validationService.isValidKey(values.get("key")))
            throw new InvalidAPIKeyException(values.get("key") + " is not a valid key !");

        stockService.editStock(values.get("isbn"), values.get("quantity"),"remove");
        return "Quantity successfully updated !";
    }
}
