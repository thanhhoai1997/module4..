package com.example.furama.model.dto;

import com.example.furama.model.Contract;
import com.example.furama.model.CustomerType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import java.sql.Date;
import java.util.List;

public class CustomerDTO implements Validator {
    private Long id;
    private String name;
@PastOrPresent(message = "Incorrect Date of Birth")
    private Date dateOfBirth;
    boolean gender;


    private String idCard;
   @Pattern(regexp = "^(090[0-9]{7})|(091[0-9]{7})$",message = "090xxxxxxx or 091xxxxxxx")
    private String phone;
   @Email(message = "Email must be formatted correctly!")
    private String email;
    private String address;

    private Long customerType;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String name, Date dateOfBirth, boolean gender, String idCard, String phone, String email, String address, Long customerType) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Long customerType) {
        this.customerType = customerType;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;
        String name = customerDTO.getName();
        String idCard = customerDTO.getIdCard();
        if (name != name.trim()) {
            errors.rejectValue("name","","Does not contain spaces at both ends !");
        }else if (!name.matches("(^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]+$)")){
            errors.rejectValue("name","","Names cannot contain numbers");
        }else {
            String[] nameArr1=name.split(" ");

            for (int i = 0; i < nameArr1.length;i++){
                String[] nameArr2 = nameArr1[i].split("");
                for (int j = 0; j < nameArr2.length; j++){
                    if (!nameArr2[0].equals(nameArr2[0].toUpperCase())){
                        errors.rejectValue("name","","The first letter of each word must be capitalized.");
                        return;
                    }
                }

            }
        }

        if (!idCard.matches("^([0-9]{7})|([0-9]{12})")){
            errors.rejectValue("idCard","","XXXXXXXXX or XXXXXXXXXXXX (X is a Number) ! ");
        }


    }
}
