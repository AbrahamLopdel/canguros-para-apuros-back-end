package com.back.canguros.para.apuros.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.canguros.para.apuros.models.Hijo;

public interface IHijoRepository extends JpaRepository<Hijo, Long> {

	List<Hijo> findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);
}
