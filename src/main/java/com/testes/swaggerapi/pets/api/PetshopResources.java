package com.testes.swaggerapi.pets.api;

import com.testes.swaggerapi.pets.model.Petshop;
import com.testes.swaggerapi.pets.repository.PetshopRepository;
import com.testes.swaggerapi.petshop.api.PetApi;
import com.testes.swaggerapi.petshop.api.model.Pet;
import com.testes.swaggerapi.petshop.api.model.PetPaginado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PetshopResources implements PetApi {

    @Autowired
    private ModelMapper modelMapper;

    private final PetshopRepository petshopRepository;

    public PetshopResources(PetshopRepository petshopRepository) {
        this.petshopRepository = petshopRepository;
    }

    @Override
    public ResponseEntity<Void> addPet(Pet body) {

        // Converting using modelmapper
        Petshop pet = modelMapper.map(body, Petshop.class);
//        pet.setName(body.getName());
//        pet.setStatus(body.getStatus());
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
        Pet response = modelMapper.map(pet, Pet.class);
//        response.setId(pet.getId());
//        response.setName(pet.getName());
//        response.setStatus(pet.getStatus());
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<PetPaginado> listPaginatedPets(Integer page, Integer perPage, String name) {
        Pageable pageable = PageRequest.of(page - 1, perPage);

        Page<Petshop> petPaged = (name.equals("")) ? petshopRepository.findAll(pageable) : petshopRepository.findByNameIgnoreCaseContains(name, pageable);

        var resPetPaged = new PetPaginado();
        resPetPaged.setPage(page.longValue());
        resPetPaged.setPerPage(perPage.longValue());
        resPetPaged.setTotalPages((long) petPaged.getTotalPages());
        resPetPaged.setTotalElements(petPaged.getTotalElements());

        List<Pet> resPets = petPaged.stream()
                .map(m -> modelMapper.map(m, Pet.class))
                .collect(Collectors.toList());
        resPetPaged.setPets(resPets);

        return ResponseEntity.ok().body(resPetPaged);
    }

    @Override
    public ResponseEntity<Void> updatePet(Pet body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updatePetWithForm(Long petId, String name, String status) {
        return null;
    }

    @PostMapping("/pet/saveall")
    public ResponseEntity<Void> saveAll(@RequestBody  List<Petshop> body) {
        if (body != null)
        {
           petshopRepository.saveAll(body);
           return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
