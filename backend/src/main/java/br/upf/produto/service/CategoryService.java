package br.upf.produto.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.upf.produto.entities.Category;
import br.upf.produto.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById( Long id ){
		return categoryRepository.findById(id).get();
	}
	
	public Category newRegister( Category category ) {
		return categoryRepository.save(category);
	}
	
	public void deleteDepartament( Long id ) {
		categoryRepository.deleteById(id);
	}
	
	public Category editDepartament( Long id, Category category) {
		
		Category dep = findById(id);
		
		BeanUtils.copyProperties(category, dep, "id");
		
		return categoryRepository.save(category);
		
	}
}
