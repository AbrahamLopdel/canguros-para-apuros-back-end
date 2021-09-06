package com.back.canguros.para.apuros.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.canguros.para.apuros.models.AnuncioCanguro;

public interface IAnuncioCanguroRepository extends JpaRepository<AnuncioCanguro, Long> {

	List<AnuncioCanguro> findByTituloContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String titulo, String descripcion);
}
