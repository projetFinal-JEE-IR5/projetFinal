package com.projetFinal.model.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Etudiant")
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

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "Voter", 
			joinColumns = { @JoinColumn(name = "id_etudiant") }, 
			inverseJoinColumns = { @JoinColumn(name = "id_probleme") })
	Set<Probleme> problemes = new HashSet<>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "Recevoir",
			joinColumns = { @JoinColumn(name = "id_etudiant") }, 
			inverseJoinColumns = { @JoinColumn(name = "id_notification") })
	Set<Notification> notifications = new HashSet<>();

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

	public Etudiant(Integer idEtudiant, String nom, String prenom, String login, String password,
			Integer nbProbAutoriseJour, Filiere filiere, Set<Probleme> problemes, Set<Notification> notifications) {
		super();
		this.idEtudiant = idEtudiant;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.nbProbAutoriseJour = nbProbAutoriseJour;
		this.filiere = filiere;
		this.problemes = problemes;
		this.notifications = notifications;
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

	public Set<Probleme> getProblemes() {
		return problemes;
	}

	public void setProblemes(Set<Probleme> problemes) {
		this.problemes = problemes;
	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}
}
