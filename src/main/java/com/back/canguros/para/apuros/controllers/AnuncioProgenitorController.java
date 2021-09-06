package com.back.canguros.para.apuros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.canguros.para.apuros.models.AnuncioProgenitor;
import com.back.canguros.para.apuros.services.AnuncioProgenitorService;

@RestController
@RequestMapping(path = "/ads/progenitors")
public class AnuncioProgenitorController {
	
	@Autowired
	private AnuncioProgenitorService service;
	
	@PostMapping("/new")
	public AnuncioProgenitor newProgenitorAd(@RequestBody AnuncioProgenitor progenitorAd) {
        return service.add(progenitorAd);
    }
	
	@PutMapping("/update")
	public AnuncioProgenitor updateProgenitorAd(@RequestBody AnuncioProgenitor progenitorAd) {
        return service.edit(progenitorAd);
    }
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProgenitorAdById(@RequestBody AnuncioProgenitor progenitorAd, @PathVariable Long id) {
		AnuncioProgenitor existProgenitorAd = service.findById(id);
		if (existProgenitorAd !=null) {
			progenitorAd.setId(existProgenitorAd.getId());
			service.edit(progenitorAd);
			return new ResponseEntity<> (HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
    }
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteProgenitorAd(@PathVariable() Long id) {
		service.delete(id);
		return true;
    }
	
	@GetMapping({ "/select" })
	public List<AnuncioProgenitor> listado(Model model, @RequestParam(name = "q", required = false) String query) {
		List<AnuncioProgenitor> result = (query == null) ? service.findAll() : service.search(query);
		return result;
	}
	
	@GetMapping("/select/{id}")
	public AnuncioProgenitor selectProgenitorAdById(@PathVariable() Long id) {
		return service.findById(id);
    }
	
}
