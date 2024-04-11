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

import com.empresa.entities.Dependente;
import com.empresa.service.DependenteService;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/dependente")
public class DependenteController {
		
		private final DependenteService DependenteService;

		@Autowired
		public DependenteController(DependenteService DependenteService) {
			this.DependenteService = DependenteService;
		}

		@GetMapping ("/{id}")
		public ResponseEntity<Dependente> buscaDependenteIdControlId (@ PathVariable Long id) {
			Dependente Dependente = DependenteService.buscaDependenteId(id);
			if (Dependente != null) {
				return ResponseEntity.ok(Dependente);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<Dependente>> buscarDependentesPorNomeControl(@PathVariable String nome){
			List<Dependente> Dependente = DependenteService.buscarDependentePorNome(nome);
			return ResponseEntity.ok(Dependente);
		}
		
		
		@GetMapping("/")
		public ResponseEntity<List<Dependente>> buscaTodosDependenteControl(){
			List<Dependente> Dependente = DependenteService.buscaTodosDependente();
			return ResponseEntity.ok(Dependente);
		}
		
		@PostMapping("/")
		public ResponseEntity<Dependente> salvaDependenteControl(@RequestBody  Dependente Dependente){
			Dependente salvaDependente= DependenteService.salvaDependente(Dependente);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaDependente);
		}
		@PutMapping("/{id}")
		public ResponseEntity<Dependente> alterarDependenteControl(@PathVariable Long id, @RequestBody Dependente Dependente){
			Dependente alterarDependente = DependenteService.alterarDependente(id, Dependente);
			if(alterarDependente != null) {
				return ResponseEntity.ok(alterarDependente);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<String> apagaDependenteControl(@PathVariable Long id){
			boolean Dependente = DependenteService.apagarDependente(id);
			if (Dependente) {
				return ResponseEntity.ok().body("O Dependente foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}