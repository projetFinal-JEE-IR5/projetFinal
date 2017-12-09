package com.projetFinal.model.metier;

import javax.persistence.CascadeType;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Notification {
	@Id
	@GeneratedValue
	private Integer idNotification;
	@Basic
	private long dateHeureNotif;
	@Basic
	private String contenu;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_PERSONNE", unique = false)
	private Personne personne;
	
	public Notification() {
		
	}

	public Notification(Integer idNotification, long dateHeureNotif, String contenu, Personne personne) {
		super();
		this.idNotification = idNotification;
		this.dateHeureNotif = dateHeureNotif;
		this.contenu = contenu;
		this.personne = personne;
	}

	public Integer getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(Integer idNotification) {
		this.idNotification = idNotification;
	}

	public long getDateHeureNotif() {
		return dateHeureNotif;
	}

	public void setDateHeureNotif(long dateHeureNotif) {
		this.dateHeureNotif = dateHeureNotif;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
}