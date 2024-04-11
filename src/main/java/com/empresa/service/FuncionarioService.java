package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entities.Funcionario;
import com.empresa.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	private final FuncionarioRepository FuncionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository FuncionarioRepository) {
		this.FuncionarioRepository = FuncionarioRepository;
	}

	public List<Funcionario> buscaTodosFuncionario(){
		return FuncionarioRepository.findAll();
	}
	public List<Funcionario> buscarFuncionarioPorNome(String nome){
		return FuncionarioRepository.findByNome(nome);
	}
	public List<Funcionario> buscarFuncionarioPorNomeESalario(String nome, Double salario){
		return FuncionarioRepository.findByNomeAndSalario(nome, salario);
	}
	public Funcionario buscaFuncionarioId (Long id) {
		Optional <Funcionario> Funcionario = FuncionarioRepository.findById(id);
		return Funcionario.orElse(null);			
	}

	public Funcionario salvaFuncionario(Funcionario Funcionario) {
		return FuncionarioRepository.save(Funcionario);
	}

	public Funcionario alterarFuncionario(Long id, Funcionario alterarFuncionario) {
		Optional <Funcionario> existeFuncionario = FuncionarioRepository.findById(id);
		if (existeFuncionario.isPresent()) {
			alterarFuncionario.setId(id);
			return FuncionarioRepository.save(alterarFuncionario);
		}
		return null;
	}

	public boolean apagarFuncionario(Long id) {
		Optional <Funcionario> existeFuncionario = FuncionarioRepository.findById(id);
		if (existeFuncionario.isPresent()) {
			FuncionarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
}