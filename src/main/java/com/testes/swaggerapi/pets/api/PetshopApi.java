package com.testes.swaggerapi.pets.api;

import com.testes.swaggerapi.petshop.api.PetApi;
import com.testes.swaggerapi.petshop.api.model.Pet;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class PetshopApi implements PetApi {
    @Override
    public ResponseEntity<Void> addPet(Pet body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deletePet(Long petId, String apiKey) {
        return null;
    }

    @Override
    public ResponseEntity<List<Pet>> findPetsByStatus(List<String> status) {
        return null;
    }

    @Override
    public ResponseEntity<List<Pet>> findPetsByTags(List<String> tags) {
        return null;
    }

    @Override
    public ResponseEntity<Pet> getPetById(Long petId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updatePet(Pet body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updatePetWithForm(Long petId, String name, String status) {
        return null;
    }
}
