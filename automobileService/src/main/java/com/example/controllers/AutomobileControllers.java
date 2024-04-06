package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.AutomobileService;

@RestController
@RequestMapping("/automobile")
public class AutomobileControllers {

	@Autowired
	private AutomobileService automobileService;
	
	@GetMapping("/")
	public ResponseEntity<List<Automobile>> listaAutomobile(){
		List<Automobile> automobili = automobileService.getAll();
		if(automobili.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(automobili);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Automobile> getAutomobile(@PathVariable("id") Long id){
		Automobile automobile = automobileService.getAutomobileById(id);
		if(automobile == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(automobile);
	}
	
	@PostMapping("/")
	public ResponseEntity<Automobile> saveNewAutomobile(@RequestBody Automobile automobile){
		Automobile autoDaCreare = automobileService.saveAutomobile(automobile);
		return ResponseEntity.ok(autoDaCreare);
	}
	
	@GetMapping("/utente/{utenteId}")
	public ResponseEntity<List<Automobile>> listaAutoByUtenteId(@PathVariable("utenteId") Long utenteId){
		List<Automobile> automobili = automobileService.autoByUtenteId(utenteId);
		if(automobili.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(automobili);
	}
}
