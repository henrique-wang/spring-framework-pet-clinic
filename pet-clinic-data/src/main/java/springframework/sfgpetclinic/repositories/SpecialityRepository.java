package springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.sfgpetclinic.models.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
