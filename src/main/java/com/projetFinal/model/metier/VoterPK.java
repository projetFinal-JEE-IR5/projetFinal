package com.projetFinal.model.metier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VoterPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_etudiant")
	private int idEtudiant;

	@Column(name = "id_probleme")
	private int idProbleme;

	public VoterPK() {
	}

	public VoterPK(int idEtudiant, int idProbleme) {
		super();
		this.idEtudiant = idEtudiant;
		this.idProbleme = idProbleme;
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public int getIdProbleme() {
		return idProbleme;
	}

	public void setIdProbleme(int idProbleme) {
		this.idProbleme = idProbleme;
	}
}
