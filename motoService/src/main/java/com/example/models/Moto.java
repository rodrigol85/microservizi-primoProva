package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Moto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String marca;
	
	private String modello;
	
	private Long utenteId;
	
	

	public Moto() {
		super();
	}

	public Moto(Long id, String marca, String modello, Long utenteId) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.utenteId = utenteId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Long getUtenteId() {
		return utenteId;
	}

	public void setUtenteId(Long utenteId) {
		this.utenteId = utenteId;
	}

	@Override
	public String toString() {
		return "Moto [id=" + id + ", marca=" + marca + ", modello=" + modello + ", utenteId=" + utenteId + "]";
	}
	
	

}
