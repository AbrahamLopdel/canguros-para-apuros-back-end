package com.back.canguros.para.apuros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.canguros.para.apuros.models.Progenitor;
import com.back.canguros.para.apuros.repositories.IProgenitorRepository;

@Service
public class ProgenitorService implements IProgenitorService {
	
	@Autowired
	private IProgenitorRepository repositorio; 
	
	public Progenitor add(Progenitor a) {
		return repositorio.save(a);
	}

	public List<Progenitor> findAll() {
		return repositorio.findAll();
	}

	public Progenitor findById(long id) {
		return repositorio.findById(id).orElse(null);
	}

	public Progenitor edit(Progenitor a) {
		return repositorio.save(a);
	}
	
	public void delete(long id) {
		repositorio.deleteById(id);
	}
	
	public List<Progenitor> search(String cadena) {
		return repositorio.findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(cadena, cadena);
	}


}
