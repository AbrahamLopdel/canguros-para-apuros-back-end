package com.back.canguros.para.apuros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.canguros.para.apuros.models.Hijo;
import com.back.canguros.para.apuros.repositories.IHijoRepository;

@Service
public class HijoService implements IHijoService {
	
	@Autowired
	private IHijoRepository repositorio; 
	
	public Hijo add(Hijo a) {
		return repositorio.save(a);
	}

	public List<Hijo> findAll() {
		return repositorio.findAll();
	}

	public Hijo findById(long id) {
		return repositorio.findById(id).orElse(null);
	}

	public Hijo edit(Hijo a) {
		return repositorio.save(a);
	}
	
	public void delete(long id) {
		repositorio.deleteById(id);
	}
	
	public List<Hijo> search(String cadena) {
		return repositorio.findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(cadena, cadena);
	}


}
