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

import com.back.canguros.para.apuros.models.Hijo;
import com.back.canguros.para.apuros.services.HijoService;
import com.back.canguros.para.apuros.upload.storage.IStorageService;

@RestController
@RequestMapping(path = "/sons")
public class HijoController {
	
	@Autowired
	private HijoService service;
	
	@Autowired
	private IStorageService storageService;
	
	@PostMapping("/new")
	public Hijo newSon(@RequestBody Hijo son, @RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			String imageSon = storageService.store(file, son.getId());
			son.setImagen(MvcUriComponentsBuilder
					.fromMethodName(CanguroController.class, "serveFile", imageSon).build().toUriString());
		}
        return service.add(son);
    }
	
	@PutMapping("/update")
	public Hijo updateSon(@RequestBody Hijo son) {
        return service.edit(son);
    }
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateHijoById(@RequestBody Hijo son, @PathVariable Long id, @RequestParam("file") MultipartFile file) {
		Hijo existSon = service.findById(id);
		if (existSon !=null) {
			son.setId(existSon.getId());
			String imageSon;
			if (!file.isEmpty()) {
				imageSon = storageService.store(file, son.getId());
				son.setImagen(MvcUriComponentsBuilder
						.fromMethodName(CanguroController.class, "serveFile", imageSon).build().toUriString());
			} else {
				long lastId = son.getId();
				Hijo lastSon = service.findById(lastId);
				imageSon = lastSon.getImagen();
				son.setImagen(imageSon);
			}
			service.edit(son);
			return new ResponseEntity<> (HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
    }
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteSon(@PathVariable() Long id) {
		service.delete(id);
		return true;
    }
	
	@GetMapping({ "/select" })
	public List<Hijo> listado(Model model, @RequestParam(name = "q", required = false) String query) {
		List<Hijo> result = (query == null) ? service.findAll() : service.search(query);
		return result;
	}
	
	@GetMapping("/select/{id}")
	public Hijo selectSonById(@PathVariable() Long id) {
		return service.findById(id);
    }
	
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().body(file);
	}
	
}
