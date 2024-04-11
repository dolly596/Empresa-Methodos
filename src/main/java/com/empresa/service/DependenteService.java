package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entities.Dependente;
import com.empresa.repository.DependenteRepository;

@Service
public class DependenteService {
	
	private final DependenteRepository DependenteRepository;

	@Autowired
	public DependenteService(DependenteRepository DependenteRepository) {
		this.DependenteRepository = DependenteRepository;
	}

	public List<Dependente> buscaTodosDependente(){
		return DependenteRepository.findAll();
	}
	public List<Dependente> buscarDependentePorNome(String nome){
		return DependenteRepository.findByNome(nome);
	}
	public Dependente buscaDependenteId (Long id) {
		Optional <Dependente> Dependente = DependenteRepository.findById(id);
		return Dependente.orElse(null);			
	}

	public Dependente salvaDependente(Dependente Dependente) {
		return DependenteRepository.save(Dependente);
	}

	public Dependente alterarDependente(Long id, Dependente alterarDependente) {
		Optional <Dependente> existeDependente = DependenteRepository.findById(id);
		if (existeDependente.isPresent()) {
			alterarDependente.setId(id);
			return DependenteRepository.save(alterarDependente);
		}
		return null;
	}

	public boolean apagarDependente(Long id) {
		Optional <Dependente> existeDependente = DependenteRepository.findById(id);
		if (existeDependente.isPresent()) {
			DependenteRepository.deleteById(id);
			return true;
		}
		return false;
	}
}