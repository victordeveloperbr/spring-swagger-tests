package com.testes.swaggerapi.pets.repository;

import com.testes.swaggerapi.pets.model.Petshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetshopRepository extends JpaRepository<Petshop, Long> {
}
