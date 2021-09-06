package com.back.canguros.para.apuros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.canguros.para.apuros.models.Canguro;
import com.back.canguros.para.apuros.repositories.ICanguroRepository;

@Service
public class CanguroService implements ICanguroService {
	
	@Autowired
	private ICanguroRepository repositorio; 
	
	public Canguro add(Canguro a) {
		return repositorio.save(a);
	}

	public List<Canguro> findAll() {
		return repositorio.findAll();
	}

	public Canguro findById(long id) {
		return repositorio.findById(id).orElse(null);
	}

	public Canguro edit(Canguro a) {
		return repositorio.save(a);
	}
	
	public void delete(long id) {
		repositorio.deleteById(id);
	}
	
	public List<Canguro> search(String cadena) {
		return repositorio.findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(cadena, cadena);
	}


}
