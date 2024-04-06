package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controllers.Automobile;
import com.example.repositories.AutomobileRepository;

@Service
public class AutomobileService {

	@Autowired
	private AutomobileRepository automobileRepository;
	
	public List<Automobile> getAll(){
		return automobileRepository.findAll();
	}
	
	public Automobile getAutomobileById(long id) {
		return automobileRepository.findById(id).orElse(null);
	}
	
	public Automobile saveAutomobile(Automobile automobile) {
		return automobileRepository.save(automobile);
	}
	
	public List<Automobile> autoByUtenteId(Long utenteId){
		return automobileRepository.findByUtenteId(utenteId);
	}
  }
