package springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.sfgpetclinic.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
