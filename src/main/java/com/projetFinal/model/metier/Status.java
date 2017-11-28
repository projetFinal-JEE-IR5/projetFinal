package com.projetFinal.model.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Status {
	@Id
	@GeneratedValue
	private Integer idStatus;
	private String libelle;
	
	public Status() {
		// TODO Auto-generated constructor stub
	}

	public Status(Integer idStatus, String libelle) {
		this.idStatus = idStatus;
		this.libelle = libelle;
	}

	public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
