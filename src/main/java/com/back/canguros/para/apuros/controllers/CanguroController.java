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

import com.back.canguros.para.apuros.models.Canguro;
import com.back.canguros.para.apuros.services.CanguroService;
import com.back.canguros.para.apuros.upload.storage.IStorageService;

@RestController
@RequestMapping(path = "/kangaroos")
public class CanguroController {
	
	@Autowired
	private CanguroService service;
	
	@Autowired
	private IStorageService storageService;
	
	@PostMapping("/new")
	public Canguro newKangaroo(@RequestBody Canguro kangaroo, @RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			String imageKang = storageService.store(file, kangaroo.getId());
			kangaroo.setImagen(MvcUriComponentsBuilder
					.fromMethodName(CanguroController.class, "serveFile", imageKang).build().toUriString());
		}
        return service.add(kangaroo);
    }
	
	@PutMapping("/update")
	public Canguro updateKangaroo(@RequestBody Canguro kangaroo) {
        return service.edit(kangaroo);
    }
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateKangarooById(@RequestBody Canguro kangaroo, @PathVariable Long id, @RequestParam("file") MultipartFile file) {
		Canguro existKangaroo = service.findById(id);
		if (existKangaroo !=null) {
			kangaroo.setId(existKangaroo.getId());
			String imageKang;
			if (!file.isEmpty()) {
				imageKang = storageService.store(file, kangaroo.getId());
				kangaroo.setImagen(MvcUriComponentsBuilder
						.fromMethodName(CanguroController.class, "serveFile", imageKang).build().toUriString());
			} else {
				long lastId = kangaroo.getId();
				Canguro lastKangaroo = service.findById(lastId);
				imageKang = lastKangaroo.getImagen();
				kangaroo.setImagen(imageKang);
			}
			service.edit(kangaroo);
			return new ResponseEntity<> (HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
    }
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteKangaroo(@PathVariable() Long id) {
		service.delete(id);
		return true;
    }
	
	@GetMapping({ "/select" })
	public List<Canguro> listado(Model model, @RequestParam(name = "q", required = false) String query) {
		List<Canguro> result = (query == null) ? service.findAll() : service.search(query);
		return result;
	}
	
	@GetMapping("/select/{id}")
	public Canguro selectKangarooById(@PathVariable() Long id) {
		return service.findById(id);
    }
	
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().body(file);
	}
	
}
