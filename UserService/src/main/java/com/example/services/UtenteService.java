package com.example.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.feignClients.AutomobileFeignClient;
import com.example.feignClients.MotoFeignClient;
import com.example.models.Automobile;
import com.example.models.Moto;
import com.example.models.Utente;
import com.example.repositories.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private AutomobileFeignClient autoFeing;
	
	@Autowired
	private MotoFeignClient motoFeing;
	
	
	public List<Automobile> getAutomobili(Long utenteId){
		@SuppressWarnings("unchecked")
		List<Automobile> automobili = restTemplate.getForObject("http://localhost:8002/automobile/utente/" + utenteId, List.class);
		return automobili;
	}
	
	public List<Moto> getMoto(Long utenteId){
		@SuppressWarnings("unchecked")
		List<Moto> motociclette= restTemplate.getForObject("http://localhost:8003/moto/utente/" + utenteId, List.class);
		return motociclette;
	}
	
	public Automobile saveNewAuto(Long utenteId, Automobile automobile) {
		automobile.setUtenteId(utenteId);
		Automobile nuovoAuto = autoFeing.saveAuto(automobile);
		return nuovoAuto;
		
	}
	
	public Moto saveNewMoto(Long utenteId, Moto moto) {
		moto.setUtenteId(utenteId);
		Moto nuovoMoto = motoFeing.saveMoto(moto);
		return nuovoMoto;
		
	}
	
	public List<Utente> getAll(){
		return utenteRepository.findAll();
	}
	
	public Utente getUtenteById(Long id) {
		return utenteRepository.findById(id).orElse(null);
	}
	
	public Utente saveUtente(Utente utente) {
		return utenteRepository.save(utente);
	}
	
	public Map<String, Object> getUtenteAndAutomobile(long utenteId){
		Map<String, Object> risultato = new HashMap<>();
		Utente utente = utenteRepository.findById(utenteId).orElse(null);
		
		if(utente == null) {
			risultato.put("messaggio", "L'utente non esiste");
			return risultato;
		}
			risultato.put("utente", utente);
			List<Automobile> listaAuto = autoFeing.getListAutomobile(utenteId);
			
		if(listaAuto.isEmpty()) {
			risultato.put("auto", "L'utente non ha macchine");
		}else {
			risultato.put("auto", listaAuto);
		}
		List<Moto> listaMoto = motoFeing.getListMoto(utenteId);
		if(listaMoto.isEmpty()) {
			risultato.put("moto", "L'utente non ha moto");
		}else {
			risultato.put("moto", listaMoto);
		}
		return risultato;
		
	}
}
