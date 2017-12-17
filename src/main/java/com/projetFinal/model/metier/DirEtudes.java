package com.projetFinal.model.metier;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DirEtudes")
public class DirEtudes {
	@Id
	@GeneratedValue
	private Integer idDirEtudes;
	@Basic
	private String nom;
	@Basic
	private String prenom;
	@Basic
	private String login;
	@Basic
	private String password;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_FILIERE", unique = false)
	private Filiere filiere;

	public DirEtudes() {
	}

	public DirEtudes(Integer idDirEtudes, String nom, String prenom, String login, String password, Filiere filiere) {
		super();
		this.idDirEtudes = idDirEtudes;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.filiere = filiere;
	}

	public Integer getIdDirEtudes() {
		return idDirEtudes;
	}

	public void setIdDirEtudes(Integer idDirEtudes) {
		this.idDirEtudes = idDirEtudes;
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

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
}
