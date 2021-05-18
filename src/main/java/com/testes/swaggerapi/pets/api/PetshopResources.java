package com.testes.swaggerapi.pets.api;

import com.testes.swaggerapi.pets.model.Petshop;
import com.testes.swaggerapi.pets.repository.PetshopRepository;
import com.testes.swaggerapi.petshop.api.PetApi;
import com.testes.swaggerapi.petshop.api.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class PetshopResources implements PetApi {

    private PetshopRepository petshopRepository;

    public PetshopResources(PetshopRepository petshopRepository) {
        this.petshopRepository = petshopRepository;
    }

    @Override
    public ResponseEntity<Void> addPet(Pet body) {
        Petshop pet = new Petshop();
        pet.setName(body.getName());
        pet.setStatus(body.getStatus());
        petshopRepository.save(pet);
        return ResponseEntity.ok().build();
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
        Petshop pet = petshopRepository.findById(petId).get();
        Pet response = new Pet();
        response.setId(pet.getId());
        response.setName(pet.getName());
        response.setStatus(pet.getStatus());
        return ResponseEntity.ok().body(response);
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
