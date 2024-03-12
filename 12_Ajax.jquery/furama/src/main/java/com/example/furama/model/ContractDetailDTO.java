package com.example.furama.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contract_detail_dto")
public class ContractDetailDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long attachFacilityId;
    private int quantity;



    public ContractDetailDTO() {
    }

    public ContractDetailDTO(Long id, Long attachFacilityId, int quantity) {
        this.id = id;
        this.attachFacilityId = attachFacilityId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAttachFacilityId() {
        return attachFacilityId;
    }

    public void setAttachFacilityId(Long attachFacilityId) {
        this.attachFacilityId = attachFacilityId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
