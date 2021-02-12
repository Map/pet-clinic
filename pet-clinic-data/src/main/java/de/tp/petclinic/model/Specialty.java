package de.tp.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
