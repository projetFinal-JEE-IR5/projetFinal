package com.projetFinal.model.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Probleme")
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
	@JoinColumn(name = "ID_ETUDIANT", unique = false)
	private Etudiant etudiant;
	@Basic
	private long dateHeureProbleme;

	@ManyToMany(mappedBy = "problemes")
	private Set<Etudiant> etudiants = new HashSet<>();

	public Probleme() {
	}

	public Probleme(Integer idProbleme, String objet, String contenu, Status status, Etudiant etudiant,
			long dateHeureProbleme) {
		super();
		this.idProbleme = idProbleme;
		this.objet = objet;
		this.contenu = contenu;
		this.status = status;
		this.etudiant = etudiant;
		this.dateHeureProbleme = dateHeureProbleme;
	}

	public Probleme(Integer idProbleme, String objet, String contenu, Status status, Etudiant etudiant,
			long dateHeureProbleme, Set<Etudiant> etudiants) {
		super();
		this.idProbleme = idProbleme;
		this.objet = objet;
		this.contenu = contenu;
		this.status = status;
		this.etudiant = etudiant;
		this.dateHeureProbleme = dateHeureProbleme;
		this.etudiants = etudiants;
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

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public long getDateHeureProbleme() {
		return dateHeureProbleme;
	}

	public void setDateHeureProbleme(long dateHeureProbleme) {
		this.dateHeureProbleme = dateHeureProbleme;
	}

	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
}
