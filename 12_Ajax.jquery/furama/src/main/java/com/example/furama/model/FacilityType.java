package com.example.furama.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "facility_type")
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "facilityType",cascade = CascadeType.ALL)
    private List<Facility> facilities;

    public FacilityType(Long id, String name, List<Facility> facilities) {
        this.id = id;
        this.name = name;
        this.facilities = facilities;
    }

    public FacilityType() {
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

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }
}
