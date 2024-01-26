package com.example.bt_ungdungmuonsach.repositories.bookcode;

import com.example.bt_ungdungmuonsach.model.BookCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookCodeRepository extends JpaRepository<BookCode,Long> {
}
