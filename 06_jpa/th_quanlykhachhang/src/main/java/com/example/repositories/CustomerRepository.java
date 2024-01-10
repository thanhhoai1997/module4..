package com.example.repositories;

import com.example.model.Customer;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> typedQuery = entityManager.createNamedQuery("findAll",Customer.class);

        return typedQuery.getResultList();
    }

    @Override
    public Customer findById(Long id) {

        return entityManager.find(Customer.class,id);
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        if (customer.getId() == null){
            entityManager.persist(customer);
        }else {
            entityManager.merge(customer);
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.remove(findById(id));
    }
}
