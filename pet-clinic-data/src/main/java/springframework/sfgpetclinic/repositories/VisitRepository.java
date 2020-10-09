package springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.sfgpetclinic.models.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
