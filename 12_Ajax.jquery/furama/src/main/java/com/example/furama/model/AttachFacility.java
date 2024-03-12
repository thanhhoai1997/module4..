package com.example.furama.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "attach_facility")
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cost; //gia tien
    private String unit; // don vi
    private String status;
    @OneToMany(mappedBy = "attachFacility",cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetails;

    public AttachFacility() {
    }

    public AttachFacility(Long id, String name, double cost, String unit, String status, List<ContractDetail> contractDetails) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetails = contractDetails;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
