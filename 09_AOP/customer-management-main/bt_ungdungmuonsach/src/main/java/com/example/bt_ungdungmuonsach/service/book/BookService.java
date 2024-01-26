package com.example.bt_ungdungmuonsach.service.book;

import com.example.bt_ungdungmuonsach.model.Book;
import com.example.bt_ungdungmuonsach.repositories.book.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public void updateQuantityBook(Long id) {
        iBookRepository.updateQuantityBook(id);
    }

    @Override
    public void updateQuantityBook2(Long id) {
        iBookRepository.updateQuantityBook2(id);
    }
}
