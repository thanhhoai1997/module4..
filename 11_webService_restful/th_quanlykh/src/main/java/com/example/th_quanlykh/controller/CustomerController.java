package com.example.th_quanlykh.controller;

import com.example.th_quanlykh.model.Customer;
import com.example.th_quanlykh.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAllCustomer(){
        List<Customer> customers = iCustomerService.findAll();
        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Long id){
        Customer customer = iCustomerService.findById(id);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(iCustomerService.save(customer),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id")Long id,@RequestBody Customer customer){
        Customer customer1 = iCustomerService.findById(id);
        customer.setId(customer1.getId());
        return new ResponseEntity<>(iCustomerService.save(customer), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        Customer customer = iCustomerService.findById(id);

        iCustomerService.remove(id);
        return new ResponseEntity<>(customer, HttpStatus.NO_CONTENT);
    }

}
