package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entities.Departamento;
import com.empresa.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	private final DepartamentoRepository DepartamentoRepository;

	@Autowired
	public DepartamentoService(DepartamentoRepository DepartamentoRepository) {
		this.DepartamentoRepository = DepartamentoRepository;
	}

	public List<Departamento> buscaTodosDepartamento(){
		return DepartamentoRepository.findAll();
	}
	public List<Departamento> buscarDepartamentoPorNome(String nome){
		return DepartamentoRepository.findByNome(nome);
	}
	public Departamento buscaDepartamentoId (Long id) {
		Optional <Departamento> Departamento = DepartamentoRepository.findById(id);
		return Departamento.orElse(null);			
	}

	public Departamento salvaDepartamento(Departamento Departamento) {
		return DepartamentoRepository.save(Departamento);
	}

	public Departamento alterarDepartamento(Long id, Departamento alterarDepartamento) {
		Optional <Departamento> existeDepartamento = DepartamentoRepository.findById(id);
		if (existeDepartamento.isPresent()) {
			alterarDepartamento.setId(id);
			return DepartamentoRepository.save(alterarDepartamento);
		}
		return null;
	}

	public boolean apagarDepartamento(Long id) {
		Optional <Departamento> existeDepartamento = DepartamentoRepository.findById(id);
		if (existeDepartamento.isPresent()) {
			DepartamentoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}