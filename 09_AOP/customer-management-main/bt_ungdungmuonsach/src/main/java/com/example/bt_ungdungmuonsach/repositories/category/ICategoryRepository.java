package com.example.bt_ungdungmuonsach.repositories.category;

import com.example.bt_ungdungmuonsach.model.Book;
import com.example.bt_ungdungmuonsach.model.Category;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {


    @Query("select b from Book as b where b.category.name like :name")
    Page<Book> findAllByNameCategory(@Param("name") String name, Pageable pageable);
}
