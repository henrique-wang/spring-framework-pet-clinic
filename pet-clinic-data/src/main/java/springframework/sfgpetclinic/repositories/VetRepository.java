package springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.sfgpetclinic.models.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
