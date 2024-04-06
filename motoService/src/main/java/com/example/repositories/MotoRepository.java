package com.example.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Moto;

@Repository
public interface MotoRepository extends ListCrudRepository<Moto, Long> {
	
	List<Moto> findByUtenteId(Long utenteId);

}
