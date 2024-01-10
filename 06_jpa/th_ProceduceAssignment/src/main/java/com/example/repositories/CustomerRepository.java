package com.example.repositories;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    @Transactional
    public boolean insertWithStoredProcedure(Customer customer) {
        String sql = "CALL Insert_Customer(:first_name,:last_name)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("first_name",customer.getFirstName());
        query.setParameter("last_name",customer.getLastName());

        return query.executeUpdate() == 0;
    }
}
