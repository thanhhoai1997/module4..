package com.example.bt_ungdungmuonsach.service.bookcode;

import com.example.bt_ungdungmuonsach.model.BookCode;
import com.example.bt_ungdungmuonsach.repositories.bookcode.IBookCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCodeService implements IBookCodeService{
    @Autowired
    private IBookCodeRepository iBookCodeRepository;
    @Override
    public void save(BookCode bookCode) {
        iBookCodeRepository.save(bookCode);
    }

    @Override
    public List<BookCode> findAll() {
        return iBookCodeRepository.findAll();
    }
}
