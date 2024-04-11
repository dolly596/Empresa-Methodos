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

import com.empresa.entities.Departamento;
import com.empresa.service.DepartamentoService;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/departamento")
public class DepartamentoController {
		
		private final DepartamentoService DepartamentoService;

		@Autowired
		public DepartamentoController(DepartamentoService DepartamentoService) {
			this.DepartamentoService = DepartamentoService;
		}

		@GetMapping ("/{id}")
		public ResponseEntity<Departamento> buscaDepartamentoIdControlId (@ PathVariable Long id) {
			Departamento Departamento = DepartamentoService.buscaDepartamentoId(id);
			if (Departamento != null) {
				return ResponseEntity.ok(Departamento);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<Departamento>> buscarDepartamentosPorNomeControl(@PathVariable String nome){
			List<Departamento> Departamento = DepartamentoService.buscarDepartamentoPorNome(nome);
			return ResponseEntity.ok(Departamento);
		}
		
		
		@GetMapping("/")
		public ResponseEntity<List<Departamento>> buscaTodosDepartamentoControl(){
			List<Departamento> Departamento = DepartamentoService.buscaTodosDepartamento();
			return ResponseEntity.ok(Departamento);
		}
		
		@PostMapping("/")
		public ResponseEntity<Departamento> salvaDepartamentoControl(@RequestBody  Departamento Departamento){
			Departamento salvaDepartamento= DepartamentoService.salvaDepartamento(Departamento);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaDepartamento);
		}
		@PutMapping("/{id}")
		public ResponseEntity<Departamento> alterarDepartamentoControl(@PathVariable Long id, @RequestBody Departamento Departamento){
			Departamento alterarDepartamento = DepartamentoService.alterarDepartamento(id, Departamento);
			if(alterarDepartamento != null) {
				return ResponseEntity.ok(alterarDepartamento);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<String> apagaDepartamentoControl(@PathVariable Long id){
			boolean Departamento = DepartamentoService.apagarDepartamento(id);
			if (Departamento) {
				return ResponseEntity.ok().body("O Departamento foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}