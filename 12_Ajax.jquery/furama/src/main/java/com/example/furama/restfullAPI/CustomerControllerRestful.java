package com.example.furama.restfullAPI;

import com.example.furama.model.Customer;
import com.example.furama.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/customers")
public class CustomerControllerRestful {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public ResponseEntity<Iterable<Customer>> findAllCustomers (@RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0),3);
        Page<Customer> customerList = iCustomerService.findAll(pageable);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){

        iCustomerService.save(customer);

        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        iCustomerService.deleteById(id);
    return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer){
     Customer customerById = iCustomerService.findById(id);
      customer.setId(customerById.getId());
        iCustomerService.save(customer);
        return  new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public  ResponseEntity<Customer> findById(@PathVariable("id") Long id){

        return new ResponseEntity<>(iCustomerService.findById(id),HttpStatus.OK);
    }


}
