package com.projetFinal.model.metier;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Etudiant {
	@Id
	@GeneratedValue
	private Integer idEtudiant;
	@Basic
	private String nom;
	@Basic
	private String prenom;
	@Basic
	private String login;
	@Basic
	private String password;
	@Basic
	private Integer nbProbAutoriseJour;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_FILIERE", unique = false)
	private Filiere filiere;

	public Etudiant() {
	}

	public Etudiant(Integer idEtudiant, String nom, String prenom, String login, String password,
			Integer nbProbAutoriseJour, Filiere filiere) {
		super();
		this.idEtudiant = idEtudiant;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.nbProbAutoriseJour = nbProbAutoriseJour;
		this.filiere = filiere;
	}

	public Integer getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Integer idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getNbProbAutoriseJour() {
		return nbProbAutoriseJour;
	}

	public void setNbProbAutoriseJour(Integer nbProbAutoriseJour) {
		this.nbProbAutoriseJour = nbProbAutoriseJour;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
}
