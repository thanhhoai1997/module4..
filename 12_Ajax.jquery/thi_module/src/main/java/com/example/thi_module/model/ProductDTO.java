package com.example.thi_module.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductDTO implements Validator {

    private Long id;

    private String name;

    private double price;

    private String status;


    private Long productType;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, double price, String status, Long productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.productType = productType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProductType() {
        return productType;
    }

    public void setProductType(Long productType) {
        this.productType = productType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
        String name= productDTO.getName();
        double price = productDTO.getPrice();
        String status = productDTO.getStatus();
 if (name.equals("") || name == null){
     errors.rejectValue("name","","khong duoc de trong");

 }else if (name.length() < 5){
     errors.rejectValue("name","","> 5 ki tu");
 }else if (name.length() > 50){
     errors.rejectValue("name","","< 50 ki tu");
 }
        if (price == 0) {
            errors.rejectValue("price", "", "khong duoc de trong");
        }else if (price <= 100000){
            errors.rejectValue("price", "", ">= 100000");

        }

        if (status.equals("") || status == null) {
            errors.rejectValue("status", "", "khong duoc de trong");
        }


        }
}
