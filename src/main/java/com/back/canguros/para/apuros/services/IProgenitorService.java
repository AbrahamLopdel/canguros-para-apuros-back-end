package com.back.canguros.para.apuros.services;

import java.util.List;

import com.back.canguros.para.apuros.models.Progenitor;

public interface IProgenitorService {
	public Progenitor add(Progenitor prod);
	public List<Progenitor> findAll();
	public Progenitor findById(long id);
	public Progenitor edit(Progenitor prod);
	public void delete(long id);
}
