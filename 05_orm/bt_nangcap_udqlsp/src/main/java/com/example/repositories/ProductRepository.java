package com.example.repositories;

import com.example.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductRepository implements IProductRepository {
  private static   SessionFactory sessionFactory;
  private static   EntityManager entityManager;
  static {
      sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
      entityManager = sessionFactory.createEntityManager();
  }
    @Override
    public List<Product> findAll() {
      String hql = "select c from Product as c";
        TypedQuery<Product> typedQuery = entityManager.createQuery(hql,Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public Product findOne(int id) {
      String hql = "select c from Product as c where c.id = :id";
      TypedQuery<Product> typedQuery = entityManager.createQuery(hql,Product.class);
      typedQuery.setParameter("id",id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (product.getId() == null){
                session.save(product);
                transaction.commit();

            }else {
                Product p = findOne(product.getId());
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setManufacture(product.getManufacture());
                session.update(p);
                transaction.commit();
            }
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            if (session != null){
                session.close();
            }
        }

    }

    @Override
    public void delete(int id) {
            Session session = null;
            Transaction transaction = null;
            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                Product p = findOne(id);
                session.delete(p);
                transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
            }finally {
                if (session != null ){
                    session.close();
                }
            }
    }
}
