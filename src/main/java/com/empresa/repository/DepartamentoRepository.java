package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.empresa.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
	List<Departamento> findByNome(String nome);
}