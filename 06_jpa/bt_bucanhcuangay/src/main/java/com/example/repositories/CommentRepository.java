package com.example.repositories;

import com.example.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class CommentRepository implements ICommentRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    @Transactional
    public void save(Comment comment) {
        if (comment.getId() == null){
            entityManager.persist(comment);
        }else {
            entityManager.merge(comment);
        }
    }

    @Override
    public List<Comment> findAll() {
        String sql = "select c from Comment as c";
        TypedQuery<Comment> typedQuery = entityManager.createQuery(sql,Comment.class);

        return typedQuery.getResultList();
    }
}
