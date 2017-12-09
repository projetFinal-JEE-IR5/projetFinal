package com.projetFinal.model.metier;

import javax.persistence.CascadeType;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Personne {
	@Id
	@GeneratedValue
	private Integer idPersonne;
	@Basic
	private String nom;
	@Basic
	private String prenom;
	@Basic
	private String login;
	@Basic
	private String password;
	@Basic
	private int nbVoteAutorise;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_ROLE", unique = false)
	private Role role;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_FILIERE", unique = false)
	private Filiere filiere;
	
	public Personne(Integer idPersonne, String nom, String prenom, String login, String password, int nbVoteAutorise,
			Role role, Filiere filiere) {
		super();
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.nbVoteAutorise = nbVoteAutorise;
		this.role = role;
		this.filiere = filiere;
	}

	public int getNbVoteAutorise() {
		return nbVoteAutorise;
	}

	public void setNbVoteAutorise(int nbVoteAutorise) {
		this.nbVoteAutorise = nbVoteAutorise;
	}

	public Integer getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
}
