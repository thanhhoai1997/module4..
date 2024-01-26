package com.example.bt_ungdungmuonsach.service.bookcode;

import com.example.bt_ungdungmuonsach.model.BookCode;

import java.util.List;

public interface IBookCodeService {
    void save(BookCode bookCode);
    List<BookCode> findAll();
}
