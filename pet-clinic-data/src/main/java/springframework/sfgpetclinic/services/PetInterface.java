package springframework.sfgpetclinic.services;

import springframework.sfgpetclinic.models.Pet;

import java.util.Set;

public interface PetInterface {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
