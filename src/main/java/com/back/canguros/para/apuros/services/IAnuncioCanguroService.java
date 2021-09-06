package com.back.canguros.para.apuros.services;

import java.util.List;

import com.back.canguros.para.apuros.models.AnuncioCanguro;

public interface IAnuncioCanguroService {
	public AnuncioCanguro add(AnuncioCanguro prod);
	public List<AnuncioCanguro> findAll();
	public AnuncioCanguro findById(long id);
	public AnuncioCanguro edit(AnuncioCanguro prod);
	public void delete(long id);
}
