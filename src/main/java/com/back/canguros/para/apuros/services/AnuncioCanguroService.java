package com.back.canguros.para.apuros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.canguros.para.apuros.models.AnuncioCanguro;
import com.back.canguros.para.apuros.repositories.IAnuncioCanguroRepository;

@Service
public class AnuncioCanguroService implements IAnuncioCanguroService {
	
	@Autowired
	private IAnuncioCanguroRepository repositorio; 
	
	public AnuncioCanguro add(AnuncioCanguro a) {
		return repositorio.save(a);
	}

	public List<AnuncioCanguro> findAll() {
		return repositorio.findAll();
	}

	public AnuncioCanguro findById(long id) {
		return repositorio.findById(id).orElse(null);
	}

	public AnuncioCanguro edit(AnuncioCanguro a) {
		return repositorio.save(a);
	}
	
	public void delete(long id) {
		repositorio.deleteById(id);
	}
	
	public List<AnuncioCanguro> search(String cadena) {
		return repositorio.findByTituloContainsIgnoreCaseOrDescripcionContainsIgnoreCase(cadena, cadena);
	}


}
