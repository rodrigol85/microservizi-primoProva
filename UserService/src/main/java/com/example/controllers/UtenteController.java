package com.example.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Automobile;
import com.example.models.Moto;
import com.example.models.Utente;
import com.example.services.UtenteService;

@RestController
@RequestMapping("/utente")
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Utente>> listaUtente(){
		List<Utente> utenti = utenteService.getAll();
		if(utenti.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(utenti);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Utente> getUtente(@PathVariable Long id){
		Utente utente = utenteService.getUtenteById(id);
		if(utente == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(utente);
	}
	
	@PostMapping("/")
	public ResponseEntity<Utente> saveUtente(@RequestBody Utente utente){
		Utente utenteDaSalvare = utenteService.saveUtente(utente);
		return ResponseEntity.ok(utenteDaSalvare);
	}
	
	@GetMapping("/automobile/{utenteId}")
	public ResponseEntity<List<Automobile>> getListAutomobili(@PathVariable Long utenteId){
		Utente utente = utenteService.getUtenteById(utenteId);
		if(utente == null) {
			return ResponseEntity.notFound().build();
		}
		List<Automobile> automobili = utenteService.getAutomobili(utenteId);
		return ResponseEntity.ok(automobili);
	}
	
	@GetMapping("/moto/{utenteId}")
	public ResponseEntity<List<Moto>> getListMoto(@PathVariable Long utenteId){
		Utente utente = utenteService.getUtenteById(utenteId);
		if(utente == null) {
			return ResponseEntity.notFound().build();
		}
		List<Moto> motociclette = utenteService.getMoto(utenteId);
		return ResponseEntity.ok(motociclette);
	}
	
	@PostMapping("/automobile/{utenteId}")
	public ResponseEntity<Automobile> saveNuovoAuto(@PathVariable("utenteId") Long utenteId, @RequestBody Automobile automobile){
		Automobile nuovoAutomobile = utenteService.saveNewAuto(utenteId, automobile);
		return ResponseEntity.ok(nuovoAutomobile);
	}
	
	@PostMapping("/moto/{utenteId}")
	public ResponseEntity<Moto> saveNuovoMoto(@PathVariable("utenteId") Long utenteId, @RequestBody Moto moto){
		Moto nuovaMoto = utenteService.saveNewMoto(utenteId, moto);
		return ResponseEntity.ok(nuovaMoto);
	}
	
	@GetMapping("/tutto/{utenteId}")
	public ResponseEntity<Map<String, Object>> listaDiTuttiMezzi(@PathVariable("utenteId") Long utenteId){
		Map<String, Object> risultato = utenteService.getUtenteAndAutomobile(utenteId);
		return ResponseEntity.ok(risultato);
	}
	

}
