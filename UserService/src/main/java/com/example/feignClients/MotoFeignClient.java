package com.example.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.models.Moto;

@FeignClient(name = "motoService", url = "http://localhost:8003", path = "/moto")
public interface MotoFeignClient {
	
	@PostMapping("/")
	public Moto saveMoto(@RequestBody Moto moto);
	
	@GetMapping("/utente/{utenteId}")
	public List<Moto> getListMoto(@PathVariable("utenteId") Long utenteId);

}
