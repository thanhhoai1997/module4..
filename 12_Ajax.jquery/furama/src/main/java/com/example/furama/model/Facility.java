package com.example.furama.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double area;
    private double cost;
    @Column(name = "max_people")
    private int maxPeople;
    @Column(name = "standard_room")
    private String standardRoom;
    private String description;
    @Column(name = "pool_area",nullable = true)
    private double poolArea;
    @Column(name = "number_of_floors",nullable = true)
    private int numberOfFloors; // so tang
    @Column(name = "facility_free")
    private String facilityFree;

    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "facility_type_id")
    private FacilityType facilityType;

    @OneToMany(mappedBy = "facility",cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Facility() {
    }

    public Facility(Long id, String name, double area, double cost, int maxPeople, String standardRoom, String description, double poolArea, int numberOfFloors, String facilityFree, RentType rentType, FacilityType facilityType, List<Contract> contracts) {
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
        this.contracts = contracts;
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

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
