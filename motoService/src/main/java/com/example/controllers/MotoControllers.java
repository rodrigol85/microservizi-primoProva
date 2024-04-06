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

import com.example.models.Moto;
import com.example.services.MotoService;

@RestController
@RequestMapping("/moto")
public class MotoControllers {
	
	@Autowired
	private MotoService motoService;
	
	
	@GetMapping("/")
	public ResponseEntity<List<Moto>> listaMoto(){
		List<Moto> motociclette = motoService.getAll();
		if(motociclette.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(motociclette);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Moto> getMoto(@PathVariable("id") Long id){
		Moto moto = motoService.getMotoById(id);
		if(moto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(moto);
	}
	
	@PostMapping("/")
	public ResponseEntity<Moto> saveNewMoto(@RequestBody Moto moto){
		Moto motoDaCreare = motoService.saveMoto(moto);
		return ResponseEntity.ok(motoDaCreare);
	}
	
	@GetMapping("/utente/{utenteId}")
	public ResponseEntity<List<Moto>> listaMotoByUtenteId(@PathVariable("utenteId") Long utenteId){
		List<Moto> motociclette = motoService.motoByUtenteId(utenteId);
		if(motociclette.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(motociclette);
	}

}
