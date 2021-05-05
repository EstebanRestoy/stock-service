package com.stock.stock.repository;

import com.stock.stock.entity.Book;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepository extends CrudRepository<Book, String> {

}
