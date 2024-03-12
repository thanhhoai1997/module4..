package com.example.furama.model.dto;

import com.example.furama.model.Customer;
import com.example.furama.model.Employee;
import com.example.furama.model.Facility;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.time.LocalDate;

public class ContractDTO implements Validator {
    private Long id;

    private Date startDate;

    private Date endDate;
    private double deposit;

    private double totalMoney;

    private Long employee;

    private Long customer;

    private Long facility;

    public ContractDTO() {
    }

    public ContractDTO(Long id, Date startDate, Date endDate, double deposit, double totalMoney, Long employee, Long customer, Long facility) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Long getEmployee() {
        return employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public Long getFacility() {
        return facility;
    }

    public void setFacility(Long facility) {
        this.facility = facility;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        ContractDTO contractDTO = (ContractDTO) target;
        Date startDate = contractDTO.getStartDate();
        Date endDate = contractDTO.getEndDate();
        LocalDate startDateLC = startDate.toLocalDate();
        LocalDate endDateLC = endDate.toLocalDate();
        if (startDateLC.isAfter(endDateLC)){
            errors.rejectValue("startDate","","Start Date < End Date");



        }
        if (!endDateLC.isAfter(startDateLC)){
            errors.rejectValue("endDate","","End Date > Start Date");
        }

    }
}
