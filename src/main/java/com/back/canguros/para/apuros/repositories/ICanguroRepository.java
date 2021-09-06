package com.back.canguros.para.apuros.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.canguros.para.apuros.models.Canguro;

public interface ICanguroRepository extends JpaRepository<Canguro, Long> {

	List<Canguro> findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);
}
