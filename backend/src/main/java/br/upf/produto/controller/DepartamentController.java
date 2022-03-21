package br.upf.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.upf.produto.entities.Departament;
import br.upf.produto.service.DepartamentService;

@RestController
@RequestMapping("/departament")
public class DepartamentController {
	
	@Autowired
	private DepartamentService departamentService;
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Departament>> findAll(){
		
		return ResponseEntity.ok(departamentService.findAll()); 
	}
	
	@GetMapping("/byid/{id}")
	public ResponseEntity<Departament> findById( @PathVariable Long id ){
		return ResponseEntity.ok(departamentService.findById(id));
	}
	
	@GetMapping("/findByParam")
	public ResponseEntity<Departament> findByParam( @RequestParam(required = true) Long id ){
		return ResponseEntity.ok(departamentService.findById(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById( @PathVariable Long id ) {
		departamentService.deleteDepartament(id);
	}
	
	@PostMapping("/new")
	public ResponseEntity<Departament> register( @RequestParam(required = true) Departament departament ){
		return ResponseEntity.ok(departamentService.newRegister(departament));	
	}

}
