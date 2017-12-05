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
	
	@Basic private long date_heure;
	@Basic private String contenu;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_PERSONNE", unique = false)
	private Personne personne;
	
	public Notification(Integer idNotification, long date_heure, String contenu, Personne personne) {
		super();
		this.idNotification = idNotification;
		this.date_heure = date_heure;
		this.contenu = contenu;
		this.personne = personne;
	}
	
	public Integer getIdNotification() {
		return idNotification;
	}
	public void setIdNotification(Integer idNotification) {
		this.idNotification = idNotification;
	}
	public long getDate_heure() {
		return date_heure;
	}
	public void setDate_heure(long date_heure) {
		this.date_heure = date_heure;
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