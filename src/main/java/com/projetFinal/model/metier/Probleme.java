package com.projetFinal.model.metier;

import javax.persistence.Basic;
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
	@Basic
	private String objet;
	@Basic
	private String contenu;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_STATUS", unique = false)
	private Status status;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_PERSONNE", unique = false)
	private Personne personne;
	@Basic
	private long dateHeureProbleme;
	
	public Probleme() {
	}

	public Probleme(Integer idProbleme, String objet, String contenu, Status status, Personne personne,
			long dateHeureProbleme) {
		super();
		this.idProbleme = idProbleme;
		this.objet = objet;
		this.contenu = contenu;
		this.status = status;
		this.personne = personne;
		this.dateHeureProbleme = dateHeureProbleme;
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

	public long getDateHeureProbleme() {
		return dateHeureProbleme;
	}

	public void setDateHeureProbleme(long dateHeureProbleme) {
		this.dateHeureProbleme = dateHeureProbleme;
	}
}
