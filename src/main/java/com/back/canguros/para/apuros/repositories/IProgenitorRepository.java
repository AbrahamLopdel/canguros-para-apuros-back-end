package com.back.canguros.para.apuros.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.canguros.para.apuros.models.Progenitor;

public interface IProgenitorRepository extends JpaRepository<Progenitor, Long> {

	List<Progenitor> findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);
}
