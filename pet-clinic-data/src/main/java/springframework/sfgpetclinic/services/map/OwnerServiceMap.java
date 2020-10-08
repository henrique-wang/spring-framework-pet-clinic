package springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import springframework.sfgpetclinic.models.Pet;
import springframework.sfgpetclinic.services.CrudService;

import springframework.sfgpetclinic.models.Owner;
import springframework.sfgpetclinic.services.OwnerService;
import springframework.sfgpetclinic.services.PetTypeService;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetServiceMap petServiceMap;

    public OwnerServiceMap(PetTypeService petTypeService, PetServiceMap petServiceMap) {
        this.petTypeService = petTypeService;
        this.petServiceMap = petServiceMap;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is Required");
                    }
                    if (pet.getId() == null) {
                        Pet savedPet = petServiceMap.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }


    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
