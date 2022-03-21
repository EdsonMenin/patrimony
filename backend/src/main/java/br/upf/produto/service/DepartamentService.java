package br.upf.produto.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.upf.produto.entities.Departament;
import br.upf.produto.repository.DepartamentRepository;

@Service
public class DepartamentService {
	
	@Autowired
	private DepartamentRepository departamentRepository;
	
	public List<Departament> findAll(){
		return departamentRepository.findAll();
	}
	
	public Departament findById( Long id ){
		return departamentRepository.findById(id).get();
	}
	
	public Departament newRegister( Departament departament ) {
		return departamentRepository.save(departament);
	}
	
	public void deleteDepartament( Long id ) {
		departamentRepository.deleteById(id);
	}
	
	public Departament editDepartament( Long id, Departament departament) {
		
		Departament dep = findById(id);
		
		BeanUtils.copyProperties(departament, dep, "id");
		
		return departamentRepository.save(departament);
		
	}
}
