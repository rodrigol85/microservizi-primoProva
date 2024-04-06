package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Moto;
import com.example.repositories.MotoRepository;

@Service
public class MotoService {
	
	@Autowired
	private MotoRepository motoRepository;
	
	
	public List<Moto> getAll(){
		return motoRepository.findAll();
	}
	
	public Moto getMotoById(long id) {
		return motoRepository.findById(id).orElse(null);
	}
	
	public Moto saveMoto(Moto moto) {
		return motoRepository.save(moto);
	}
	
	public List<Moto> motoByUtenteId(Long utenteId){
		return motoRepository.findByUtenteId(utenteId);
	}
  }


