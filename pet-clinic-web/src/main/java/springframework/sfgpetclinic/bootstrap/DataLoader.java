package springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.sfgpetclinic.models.Owner;
import springframework.sfgpetclinic.models.Pet;
import springframework.sfgpetclinic.models.PetType;
import springframework.sfgpetclinic.models.Vet;
import springframework.sfgpetclinic.services.OwnerService;
import springframework.sfgpetclinic.services.PetService;
import springframework.sfgpetclinic.services.PetTypeService;
import springframework.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded Pet Types..");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiora");
        owner2.setLastName("Glenante");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sammy");
        vet2.setLastName("Axey");

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
