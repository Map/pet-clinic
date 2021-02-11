package de.tp.petclinic.repositories;

import de.tp.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 8/5/18.
 */
public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
