package com.testes.swaggerapi.pets.model;

import com.testes.swaggerapi.petshop.api.model.Pet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Petshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Pet.StatusEnum status;

    public Petshop() {
    }

    public Petshop(String name, Pet.StatusEnum status) {
        this.name = name;
        this.status = status;
    }

    public Petshop(Long id, String name, Pet.StatusEnum status) {
        this.id = id;
        this.name = name;
        this.status = status;
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

    public Pet.StatusEnum getStatus() {
        return status;
    }

    public void setStatus(Pet.StatusEnum status) {
        this.status = status;
    }
}
