package de.tp.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="specialties")
public class Specialty extends BaseEntity{
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String desription) {
        this.description = desription;
    }
}
