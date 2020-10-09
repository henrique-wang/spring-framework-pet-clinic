package springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.sfgpetclinic.models.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
