package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entities.Funcionario;
import com.empresa.service.FuncionarioService;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/funcionario")
public class FuncionarioController {
		
		private final FuncionarioService FuncionarioService;

		@Autowired
		public FuncionarioController(FuncionarioService FuncionarioService) {
			this.FuncionarioService = FuncionarioService;
		}

		@GetMapping ("/{id}")
		public ResponseEntity<Funcionario> buscaFuncionarioIdControlId (@ PathVariable Long id) {
			Funcionario Funcionario = FuncionarioService.buscaFuncionarioId(id);
			if (Funcionario != null) {
				return ResponseEntity.ok(Funcionario);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<Funcionario>> buscarFuncionariosPorNomeControl(@PathVariable String nome){
			List<Funcionario> Funcionario = FuncionarioService.buscarFuncionarioPorNome(nome);
			return ResponseEntity.ok(Funcionario);
		}
		@GetMapping("/nome/{nome}/salario/{salario}")
		public ResponseEntity<List<Funcionario>> buscarFuncionariosPorNomeSalarioControl(@PathVariable String nome, @PathVariable Double salario){
			List<Funcionario> Funcionario = FuncionarioService.buscarFuncionarioPorNomeESalario(nome, salario);
			return ResponseEntity.ok(Funcionario);
		}
		
		@GetMapping("/")
		public ResponseEntity<List<Funcionario>> buscaTodosFuncionarioControl(){
			List<Funcionario> Funcionario = FuncionarioService.buscaTodosFuncionario();
			return ResponseEntity.ok(Funcionario);
		}
		
		@PostMapping("/")
		public ResponseEntity<Funcionario> salvaFuncionarioControl(@RequestBody  Funcionario Funcionario){
			Funcionario salvaFuncionario= FuncionarioService.salvaFuncionario(Funcionario);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaFuncionario);
		}
		@PutMapping("/{id}")
		public ResponseEntity<Funcionario> alterarFuncionarioControl(@PathVariable Long id, @RequestBody Funcionario Funcionario){
			Funcionario alterarFuncionario = FuncionarioService.alterarFuncionario(id, Funcionario);
			if(alterarFuncionario != null) {
				return ResponseEntity.ok(alterarFuncionario);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<String> apagaFuncionarioControl(@PathVariable Long id){
			boolean Funcionario = FuncionarioService.apagarFuncionario(id);
			if (Funcionario) {
				return ResponseEntity.ok().body("O Funcionario foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}