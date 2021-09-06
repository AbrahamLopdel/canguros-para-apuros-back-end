package com.back.canguros.para.apuros.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.back.canguros.para.apuros.models.AnuncioProgenitor;

public interface IAnuncioProgenitorRepository extends JpaRepository<AnuncioProgenitor, Long> {

	List<AnuncioProgenitor> findByTituloContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String titulo, String descripcion);
}
