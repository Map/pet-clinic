package de.tp.petclinic.model;

import java.time.LocalDate;

public class Pet {

    private PetType petType;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    private Owner owner;
    private LocalDate localDate;
}
