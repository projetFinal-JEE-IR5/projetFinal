package com.projetFinal.model.metier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RecevoirPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "id_notification")
	private int idNotification;

	@Column(name = "id_etudiant")
	private int idEtudiant;

	public RecevoirPK() {
	}

	public RecevoirPK(int idNotification, int idEtudiant) {
		super();
		this.idNotification = idNotification;
		this.idEtudiant = idEtudiant;
	}

	public int getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
}