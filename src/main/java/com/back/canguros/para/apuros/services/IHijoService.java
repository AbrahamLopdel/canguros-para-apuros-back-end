package com.back.canguros.para.apuros.services;

import java.util.List;

import com.back.canguros.para.apuros.models.Hijo;

public interface IHijoService {
	public Hijo add(Hijo prod);
	public List<Hijo> findAll();
	public Hijo findById(long id);
	public Hijo edit(Hijo prod);
	public void delete(long id);
}
