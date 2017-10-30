package com.projetFinal.model.metier;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Probleme {
	@Id
	@GeneratedValue
	private Integer idProbleme;
	private String objet;
	private String contenu;
	private Integer vote;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_STATUS", unique = false)
	private Status status;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_PERSONNE", unique = false)
	private Personne personne;
	private Timestamp dateHeure;
	
	public Probleme(Integer idProbleme, String objet, String contenu, Integer vote, Status status, Personne personne,
			Timestamp dateHeure) {
		super();
		this.idProbleme = idProbleme;
		this.objet = objet;
		this.contenu = contenu;
		this.vote = vote;
		this.status = status;
		this.personne = personne;
		this.dateHeure = dateHeure;
	}
	
	public Integer getIdProbleme() {
		return idProbleme;
	}
	public void setIdProbleme(Integer idProbleme) {
		this.idProbleme = idProbleme;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Integer getVote() {
		return vote;
	}
	public void setVote(Integer vote) {
		this.vote = vote;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public Timestamp getDateHeure() {
		return dateHeure;
	}
	public void setDateHeure(Timestamp dateHeure) {
		this.dateHeure = dateHeure;
	}
}
