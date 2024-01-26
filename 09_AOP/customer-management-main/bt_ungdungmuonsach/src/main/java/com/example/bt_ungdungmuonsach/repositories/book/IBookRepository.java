package com.example.bt_ungdungmuonsach.repositories.book;

import com.example.bt_ungdungmuonsach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
    @Transactional
    @Modifying()
    @Query("update Book  b set  b.quantity = b.quantity -1 where b.id = :id  ")
    void updateQuantityBook(@Param("id") Long id);

    @Transactional
    @Modifying()
    @Query("update Book  b set  b.quantity = b.quantity +1 where b.id = :id  ")
    void updateQuantityBook2(@Param("id") Long id);


}
