package com.example.repositories;

import com.example.model.Music;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class MusicRepository implements IMusicRepository {
    @PersistenceContext
    private  EntityManager entityManager;

    @Override
    public List<Music> findAll() {
        String sql = "select m from Music as m";
        TypedQuery<Music> typedQuery = entityManager.createQuery(sql,Music.class);
        return typedQuery.getResultList();

    }

    @Override
    @Transactional
    public void save(Music music) {
        entityManager.persist(music);

    }

    @Override
    @Transactional
    public void delete(int id) {
       entityManager.remove(findOne(id));

    }


    @Override
    public Music findOne(int id) {
        String hql = "select m from Music as m where m.id = :id";
        TypedQuery<Music> typedQuery = entityManager.createQuery(hql,Music.class);
        typedQuery.setParameter("id",id);
        return typedQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Music music) {
        entityManager.merge(music);

    }
}
