package br.upf.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.upf.produto.entities.Departament;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Long>{

}
