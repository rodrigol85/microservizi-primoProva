package com.example.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Utente;

@Repository
public interface UtenteRepository extends ListCrudRepository<Utente, Long> {

}
