package com.example.bt_validate_form.model;

import jakarta.validation.constraints.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Locale;

public class UserDTO implements Validator {
    @NotBlank(message = "The student's first name must not be empty")
    @Size(min = 5,message = ">= 5 character")
    @Size(max = 45,message = "<=45 character")

    private String firstName;

    @NotBlank(message = "The student's last name must not be empty")
    @Size(min = 5,message = ">=5 character")
    @Size(max = 45,message = "<=45 character")
    private String lastName;

    @Pattern(regexp = "^(0[0-9]{8})|(0[0-9]{9})$",message = "number false")
    private String phoneNumber;


    private LocalDate age;
    @Email(message = "email false")
    private String email;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String phoneNumber, LocalDate age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();
        String numberPhone = userDTO.getPhoneNumber();
        LocalDate age = userDTO.getAge();
        String email = userDTO.getEmail();
        if (firstName.equals("")){
            errors.rejectValue("firstName","","First Name k duoc de trong");


        }else if (firstName.length() < 5){
            errors.rejectValue("firstName","","FN >= 5 character");
        }else if (firstName.length() > 45 ){
            errors.rejectValue("firstName","","FN <= 45");
        }
        if (lastName.equals("")){
            errors.rejectValue("lastName","","lastName k duoc de trong");


        }else if (lastName.length() < 5){
            errors.rejectValue("lastName","","lastName >= 5 character");
        }else if (lastName.length() > 45 ){
            errors.rejectValue("lastName","","lastName <= 45");
        }
        if (numberPhone.length()>11 || numberPhone.length()<10){
            errors.rejectValue("phoneNumber", "","sdt 10 or 11");
        }else
        if (!numberPhone.startsWith("0")){
            errors.rejectValue("phoneNumber", "","sdt bat dau = 0");
        }else
        if (!numberPhone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "","k dc chua character");
        }
        LocalDate localDate = LocalDate.now()  ;
        int year = Period.between(age, localDate).getYears();

        if (year <= 18 ) {
            errors.rejectValue("age","","age >= 18");

        }

        if (!email.matches("^[a-z0-9]+\\@[a-z]+\\.[a-z]+")){
            errors.rejectValue("email","","Email flase");
        }


    }
}
