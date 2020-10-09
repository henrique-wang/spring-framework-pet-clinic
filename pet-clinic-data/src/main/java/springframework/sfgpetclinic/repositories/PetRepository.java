package springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.sfgpetclinic.models.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
