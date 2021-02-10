package de.tp.petclinic.bootstrap;

import de.tp.petclinic.model.*;
import de.tp.petclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;


    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDesription("Radiologiy");
        Specialty savedRadiology= specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDesription("surgery");
        Specialty savedSurgery= specialtiesService.save(surgery);


        Specialty dentistry = new Specialty();
        dentistry.setDesription("dentistry");
        Specialty savedDentistry= specialtiesService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123n Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123123123");

        Pet mikesPet=new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthdate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123n Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("123123123");

        Pet fionasCat= new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthdate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);
        System.out.println("loaded owners.");

        Vet vet1= new Vet();
        vet1.setFirstName("Same");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2= new Vet();

        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedDentistry);
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("loaded vets");
    }

}
