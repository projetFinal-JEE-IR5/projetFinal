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
@Table(name = "Filiere")
public class Filiere {
	@Id
	@GeneratedValue
	private Integer idFiliere;
	@Basic
	private String nomFiliere;
	@Basic
	private String abreviation;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_DIR_ETUDES", unique = false)
	private DirEtudes dir_etudes;

	public Filiere() {
	}

	public Filiere(Integer idFiliere, String nomFiliere, String abreviation, DirEtudes dir_etudes) {
		super();
		this.idFiliere = idFiliere;
		this.nomFiliere = nomFiliere;
		this.abreviation = abreviation;
		this.dir_etudes = dir_etudes;
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

	public DirEtudes getDir_etudes() {
		return dir_etudes;
	}

	public void setDir_etudes(DirEtudes dir_etudes) {
		this.dir_etudes = dir_etudes;
	}
}
