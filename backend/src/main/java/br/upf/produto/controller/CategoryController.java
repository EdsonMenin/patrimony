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

import br.upf.produto.entities.Category;
import br.upf.produto.entities.Departament;
import br.upf.produto.service.CategoryService;
import br.upf.produto.service.DepartamentService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Category>> findAll(){
		
		return ResponseEntity.ok(categoryService.findAll()); 
	}
	
	@GetMapping("/byid/{id}")
	public ResponseEntity<Category> findById( @PathVariable Long id ){
		return ResponseEntity.ok(categoryService.findById(id));
	}
	
	@GetMapping("/findByParam")
	public ResponseEntity<Category> findByParam( @RequestParam(required = true) Long id ){
		return ResponseEntity.ok(categoryService.findById(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById( @PathVariable Long id ) {
		categoryService.deleteDepartament(id);
	}
	
	@PostMapping("/new")
	public ResponseEntity<Category> register( @RequestParam(required = true) Category category ){
		return ResponseEntity.ok(categoryService.newRegister(category));	
	}

}
