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

	public Status(Integer idRole, String libelle) {
		this.idStatus = idRole;
		this.libelle = libelle;
	}

	public Integer getIdRole() {
		return idStatus;
	}

	public void setIdRole(Integer idRole) {
		this.idStatus = idRole;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
