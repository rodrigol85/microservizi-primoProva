package com.example.repositories;

import java.util.List;


import org.springframework.data.repository.ListCrudRepository;

import com.example.controllers.Automobile;

public interface AutomobileRepository extends ListCrudRepository<Automobile, Long> {
	
	List<Automobile> findByUtenteId(Long utenteId);

}
