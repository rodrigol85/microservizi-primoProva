package com.example.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.models.Automobile;

@FeignClient(name = "automobileService", url = "http://localhost:8002", path = "/automobile")
public interface AutomobileFeignClient {
	
	@PostMapping("/")
	public Automobile saveAuto(@RequestBody Automobile automobile);
	
	@GetMapping("/utente/{utenteId}")
	public List<Automobile> getListAutomobile(@PathVariable("utenteId") Long utenteId);

}
