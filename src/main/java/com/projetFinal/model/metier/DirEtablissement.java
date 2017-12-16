package com.projetFinal.model.metier;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DirEtablissement {
	@Id
	@GeneratedValue
	private Integer idDirEtablissement;
	@Basic
	private String nom;
	@Basic
	private String prenom;
	@Basic
	private String login;
	@Basic
	private String password;

	public DirEtablissement() {
	}

	public DirEtablissement(Integer idDirEtablissement, String nom, String prenom, String login, String password) {
		super();
		this.idDirEtablissement = idDirEtablissement;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}

	public Integer getIdDirEtablissement() {
		return idDirEtablissement;
	}

	public void setIdDirEtablissement(Integer idDirEtablissement) {
		this.idDirEtablissement = idDirEtablissement;
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
}
