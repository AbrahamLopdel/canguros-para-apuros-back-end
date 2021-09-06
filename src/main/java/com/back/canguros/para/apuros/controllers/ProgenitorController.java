package com.back.canguros.para.apuros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.back.canguros.para.apuros.models.Progenitor;
import com.back.canguros.para.apuros.services.ProgenitorService;
import com.back.canguros.para.apuros.upload.storage.IStorageService;

@RestController
@RequestMapping(path = "/progenitors")
public class ProgenitorController {
	
	@Autowired
	private ProgenitorService service;
	
	@Autowired
	private IStorageService storageService;
	
	@PostMapping("/new")
	public Progenitor newProgenitor(@RequestBody Progenitor progenitor, @RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			String imageSon = storageService.store(file, progenitor.getId());
			progenitor.setImagen(MvcUriComponentsBuilder
					.fromMethodName(CanguroController.class, "serveFile", imageSon).build().toUriString());
		}
        return service.add(progenitor);
    }
	
	@PutMapping("/update")
	public Progenitor updateProgenitor(@RequestBody Progenitor progenitor) {
        return service.edit(progenitor);
    }
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProgenitorById(@RequestBody Progenitor progenitor, @PathVariable Long id, @RequestParam("file") MultipartFile file) {
		Progenitor existProgenitor = service.findById(id);
		if (existProgenitor !=null) {
			progenitor.setId(existProgenitor.getId());
			String imageProgenitor;
			if (!file.isEmpty()) {
				imageProgenitor = storageService.store(file, progenitor.getId());
				progenitor.setImagen(MvcUriComponentsBuilder
						.fromMethodName(CanguroController.class, "serveFile", imageProgenitor).build().toUriString());
			} else {
				long lastId = progenitor.getId();
				Progenitor lastProgenitor = service.findById(lastId);
				imageProgenitor = lastProgenitor.getImagen();
				progenitor.setImagen(imageProgenitor);
			}
			service.edit(progenitor);
			return new ResponseEntity<> (HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
    }
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteProgenitor(@PathVariable() Long id) {
		service.delete(id);
		return true;
    }
	
	@GetMapping({ "/select" })
	public List<Progenitor> listado(Model model, @RequestParam(name = "q", required = false) String query) {
		List<Progenitor> result = (query == null) ? service.findAll() : service.search(query);
		return result;
	}
	
	@GetMapping("/select/{id}")
	public Progenitor selectProgenitorById(@PathVariable() Long id) {
		return service.findById(id);
    }
	
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().body(file);
	}
	
}
