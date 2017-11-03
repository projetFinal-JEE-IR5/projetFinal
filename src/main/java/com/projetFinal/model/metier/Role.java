package com.projetFinal.model.metier;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	@GeneratedValue
	private Integer idRole;
	@Basic private String libelle;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(Integer idRole, String libelle) {
		this.idRole = idRole;
		this.libelle = libelle;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
