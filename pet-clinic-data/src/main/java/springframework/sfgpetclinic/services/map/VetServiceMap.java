package springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import springframework.sfgpetclinic.models.Speciality;
import springframework.sfgpetclinic.models.Vet;
import springframework.sfgpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityServiceMap specialityServiceMap;

    public VetServiceMap(SpecialityServiceMap specialityServiceMap) {
        this.specialityServiceMap = specialityServiceMap;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
    }

    @Override
    public void delete(Vet object) {
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null){
                    Speciality savedSpeciality = specialityServiceMap.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
