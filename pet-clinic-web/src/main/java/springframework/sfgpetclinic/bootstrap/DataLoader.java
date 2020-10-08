package springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.sfgpetclinic.models.*;
import springframework.sfgpetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialitiesService specialitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petService.findAll().size();
        if (count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRad = specialitiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurg = specialitiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDen = specialitiesService.save(dentistry);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded Pet Types..");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("324325534");

        Pet michaelPet = new Pet();
        michaelPet.setPetType(dog);
        michaelPet.setOwner(owner1);
        michaelPet.setBirthday(LocalDate.now());
        michaelPet.setName("Rosco");
        owner1.getPets().add(michaelPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiora");
        owner2.setLastName("Glenante");
        owner2.setAddress("234 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("224325534");

        Pet FionaPet = new Pet();
        FionaPet.setPetType(cat);
        FionaPet.setOwner(owner2);
        FionaPet.setBirthday(LocalDate.now());
        FionaPet.setName("Catty");
        owner2.getPets().add(FionaPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sammy");
        vet2.setLastName("Axey");
        vet2.getSpecialities().add(dentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

        Pet pet1 = new Pet();
        pet1.setOwner(owner1);
        pet1.setBirthday(LocalDate.of(2020, 1, 8));

        petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setOwner(owner2);
        pet2.setBirthday(LocalDate.of(2020, 2, 8));

        petService.save(pet2);

        System.out.println("Loaded Pets.....");
    }
}
