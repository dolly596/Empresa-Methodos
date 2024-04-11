package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.empresa.entities.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Long>{
	List<Dependente> findByNome(String nome);
}