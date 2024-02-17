package com.example.repositories.blog;

import com.example.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Long> {



    @Query("select b from Blog as b where b.title like :title")
    Page<Blog> findAllByTitle(@Param("title") String title, Pageable pageable);

    @Query("select b from Blog as b where b.category.name like :name")
    Page<Blog> findAllByCategoryName(@Param("name") String s, Pageable pageable);
}
