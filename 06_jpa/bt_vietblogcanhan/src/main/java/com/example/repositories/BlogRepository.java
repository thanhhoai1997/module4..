package com.example.repositories;

import com.example.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class BlogRepository implements IBlogRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Blog> findAll() {
        String sql = "select b from Blog as b";
        TypedQuery<Blog> typedQuery = entityManager.createQuery(sql, Blog.class);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void save(Blog blog) {
        if (blog.getId() == null){
            entityManager.persist(blog);
        }else {
            entityManager.merge(blog);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(findOne(id));
    }

    @Override
    public Blog findOne(int id) {
        return entityManager.find(Blog.class,id);

    }
}
