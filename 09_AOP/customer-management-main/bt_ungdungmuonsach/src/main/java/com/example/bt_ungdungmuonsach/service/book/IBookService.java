package com.example.bt_ungdungmuonsach.service.book;

import com.example.bt_ungdungmuonsach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);
    void save(Book book);
    Book findById(Long id);

    void updateQuantityBook(Long id);

    void updateQuantityBook2(Long id);
}
