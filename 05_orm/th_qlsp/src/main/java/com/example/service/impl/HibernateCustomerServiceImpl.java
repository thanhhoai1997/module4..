package com.example.service.impl;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.sun.org.apache.xerces.internal.impl.XMLEntityManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class HibernateCustomerServiceImpl implements CustomerService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager ;
    static {
        sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
        entityManager = sessionFactory.createEntityManager();
    }


    @Override
    public List<Customer> findAll() {
        String hql = "select c from Customer as c";
        TypedQuery<Customer> query = entityManager.createQuery(hql,Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findOne(Long id) {
        String hql = "select c from Customer as c  where c.id = :id";
        TypedQuery<Customer> query = entityManager.createQuery(hql,Customer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public Customer save(Customer customer) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            if (customer.getId() == null){
                session.save(customer);
                transaction.commit();
                return customer;
            }else {
                Customer customer1 = findOne(customer.getId());
                customer1.setName(customer.getName());
                customer1.setEmail(customer.getEmail());
                customer1.setAddress(customer.getAddress());
                session.update(customer1);
                transaction.commit();
                return customer1;
            }

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            if (session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {
        Session session = null;
        Transaction  transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Customer customer = findOne(id);
            session.delete(customer);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.commit();
        }finally {
            if (session != null){
                session.close();
            }
        }


    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void delete(List<Customer> customers) {

    }

    @Override
    public void deleteAll() {

    }
}
