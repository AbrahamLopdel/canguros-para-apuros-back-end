package com.back.canguros.para.apuros.services;

import java.util.List;

import com.back.canguros.para.apuros.models.AnuncioProgenitor;

public interface IAnuncioProgenitorService {
	public AnuncioProgenitor add(AnuncioProgenitor prod);
	public List<AnuncioProgenitor> findAll();
	public AnuncioProgenitor findById(long id);
	public AnuncioProgenitor edit(AnuncioProgenitor prod);
	public void delete(long id);
}
