package com.example.furama.restfullAPI;

import com.example.furama.model.CustomerType;
import com.example.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/customer_type")
@CrossOrigin("*")
public class CustomerTypeControllerRestfull {

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public ResponseEntity<Iterable<CustomerType>> FindAllCustomerType () {

        List<CustomerType> customerTypes = iCustomerTypeService.findAll();
        return new ResponseEntity<>(customerTypes, HttpStatus.OK);




    }
}
