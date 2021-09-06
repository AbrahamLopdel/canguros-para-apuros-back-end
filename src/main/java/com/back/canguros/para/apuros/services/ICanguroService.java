package com.back.canguros.para.apuros.services;

import java.util.List;

import com.back.canguros.para.apuros.models.Canguro;

public interface ICanguroService {
	public Canguro add(Canguro prod);
	public List<Canguro> findAll();
	public Canguro findById(long id);
	public Canguro edit(Canguro prod);
	public void delete(long id);
}
