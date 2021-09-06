package com.back.canguros.para.apuros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.canguros.para.apuros.models.AnuncioProgenitor;
import com.back.canguros.para.apuros.repositories.IAnuncioProgenitorRepository;

@Service
public class AnuncioProgenitorService implements IAnuncioProgenitorService {
	
	@Autowired
	private IAnuncioProgenitorRepository repositorio; 
	
	public AnuncioProgenitor add(AnuncioProgenitor a) {
		return repositorio.save(a);
	}

	public List<AnuncioProgenitor> findAll() {
		return repositorio.findAll();
	}

	public AnuncioProgenitor findById(long id) {
		return repositorio.findById(id).orElse(null);
	}

	public AnuncioProgenitor edit(AnuncioProgenitor a) {
		return repositorio.save(a);
	}
	
	public void delete(long id) {
		repositorio.deleteById(id);
	}
	
	public List<AnuncioProgenitor> search(String cadena) {
		return repositorio.findByTituloContainsIgnoreCaseOrDescripcionContainsIgnoreCase(cadena, cadena);
	}


}
