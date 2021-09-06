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

import com.back.canguros.para.apuros.models.AnuncioCanguro;
import com.back.canguros.para.apuros.services.AnuncioCanguroService;

@RestController
@RequestMapping(path = "/ads/kangaroos")
public class AnuncioCanguroController {
	
	@Autowired
	private AnuncioCanguroService service;
	
	@PostMapping("/new")
	public AnuncioCanguro newKangarooAd(@RequestBody AnuncioCanguro kangarooAd) {
        return service.add(kangarooAd);
    }
	
	@PutMapping("/update")
	public AnuncioCanguro updateKangarooAd(@RequestBody AnuncioCanguro kangarooAd) {
        return service.edit(kangarooAd);
    }
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateKangarooAdById(@RequestBody AnuncioCanguro kangarooAd, @PathVariable Long id) {
		AnuncioCanguro existKangarooAd = service.findById(id);
		if (existKangarooAd !=null) {
			kangarooAd.setId(existKangarooAd.getId());
			service.edit(kangarooAd);
			return new ResponseEntity<> (HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
    }
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteKangarooAd(@PathVariable() Long id) {
		service.delete(id);
		return true;
    }
	
	@GetMapping({ "/select" })
	public List<AnuncioCanguro> listado(Model model, @RequestParam(name = "q", required = false) String query) {
		List<AnuncioCanguro> result = (query == null) ? service.findAll() : service.search(query);
		return result;
	}
	
	@GetMapping("/select/{id}")
	public AnuncioCanguro selectKangarooAdById(@PathVariable() Long id) {
		return service.findById(id);
    }
	
}
