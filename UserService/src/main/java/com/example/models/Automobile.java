package com.example.models;

public class Automobile {
	
	private String marca;
	
	private String modello;
	
	private Long utenteId;

	public Automobile() {
		super();
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

	public void setModello(String modelo) {
		this.modello = modelo;
	}

	public Long getUtenteId() {
		return utenteId;
	}

	public void setUtenteId(Long utenteId) {
		this.utenteId = utenteId;
	}
	
	

}
