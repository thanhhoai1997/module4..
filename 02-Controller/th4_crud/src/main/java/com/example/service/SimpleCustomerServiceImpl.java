package com.example.service;

import com.example.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class SimpleCustomerServiceImpl implements CustomerService{
    private static List<Customer> customers;
    private static long autoIncreaseId = 0;
    static {
        customers = new ArrayList<>();
        customers.add(new Customer(autoIncreaseId++, "T", "t@codegym.vn", "Da Nang"));
        customers.add(new Customer(autoIncreaseId++, "Nhat", "nhat@codegym.vn", "Quang Tri"));
        customers.add(new Customer(autoIncreaseId++, "Trang", "trang@codegym.vn", "Ha Noi"));
        customers.add(new Customer(autoIncreaseId++, "Nguyen Binh Son", "son@codegym.vn", "Sai Gon"));
        customers.add(new Customer(autoIncreaseId++, "Dang Xuan Hoa", "hoa.dang@codegym.vn", "Da Nang"));


    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findOne(Long id) {
        for (Customer c: customers
             ) {
            if (c.getId() == id){
                return c;
            }

        }
        return null;
    }

    @Override
    public void save(Customer customer) {
        customers.set((int) (customer.getId()-1),customer);
    }
}
