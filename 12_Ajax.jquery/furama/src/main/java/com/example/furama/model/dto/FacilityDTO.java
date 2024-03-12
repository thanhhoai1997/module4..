package com.example.furama.model.dto;

import com.example.furama.model.FacilityType;
import com.example.furama.model.RentType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FacilityDTO implements Validator {
    private Long id;
    private String name;
    private double area;
    private double cost;

    private int maxPeople;

    private String standardRoom;
    private String description;

    private double poolArea;
   @Min(value = 1,message = "Number Of Floors must be a positive integer ! ")
    private int numberOfFloors; // so tang

    private String facilityFree;


    private Long rentType;


    private Long facilityType;

    public FacilityDTO() {
    }

    public FacilityDTO(Long id, String name, double area, double cost, int maxPeople, String standardRoom, String description, double poolArea, int numberOfFloors, String facilityFree, Long rentType, Long facilityType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.rentType = rentType;
        this.facilityType = facilityType;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public Long getRentType() {
        return rentType;
    }

    public void setRentType(Long rentType) {
        this.rentType = rentType;
    }

    public Long getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(Long facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        FacilityDTO facilityDTO = (FacilityDTO) target;
        String name = facilityDTO.getName();
        if (!name.matches("(^[a-zA-Z0-9 ]+$)")){
            errors.rejectValue("name","", "Does not contain special characters");
        }else {
            String arrName[] = name.split(" ");
            for (int i = 0; i < arrName.length;i++){
                String arrName2[] = arrName[i].split("");
                for (int j = 0; j < arrName2.length;j++){
                    if (!arrName2[0].equals(arrName2[0].toUpperCase())){
                        errors.rejectValue("name","","The first letter of each word must be capitalized!");
                        return;
                    }
                }
            }
        }
    }
}
