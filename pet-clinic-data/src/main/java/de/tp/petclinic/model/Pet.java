package de.tp.petclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="pets")
public class Pet extends BaseEntity {
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthdate) {
        this.birthDate = birthdate;
    }

    private LocalDate birthDate;
}
