package com.projetFinal.model.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Filiere {
	@Id
	@GeneratedValue
	private Integer idFiliere;
	private String nomFiliere;
	private String abreviation;

	public Filiere(Integer idRole, String libelle, String abreviation) {
		this.idFiliere = idRole;
		this.nomFiliere = libelle;
		this.abreviation = abreviation;
	}

	public Integer getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(Integer idFiliere) {
		this.idFiliere = idFiliere;
	}

	public String getNomFiliere() {
		return nomFiliere;
	}

	public void setNomFiliere(String nomFiliere) {
		this.nomFiliere = nomFiliere;
	}

	public String getAbreviation() {
		return abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}
}
