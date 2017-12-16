package com.projetFinal.model.metier;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
	@JoinColumn(name = "ID_DIR_ETUDES", unique = false)
	private DirEtudes dir_etudes;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_DIR_ETABLISSEMENT", unique = false)
	private DirEtablissement dir_etablissement;

	public Notification() {

	}

	public Notification(Integer idNotification, long dateHeureNotif, String contenu, DirEtudes dir_etudes,
			DirEtablissement dir_etablissement) {
		super();
		this.idNotification = idNotification;
		this.dateHeureNotif = dateHeureNotif;
		this.contenu = contenu;
		this.dir_etudes = dir_etudes;
		this.dir_etablissement = dir_etablissement;
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

	public DirEtudes getDir_etudes() {
		return dir_etudes;
	}

	public void setDir_etudes(DirEtudes dir_etudes) {
		this.dir_etudes = dir_etudes;
	}

	public DirEtablissement getDir_etablissement() {
		return dir_etablissement;
	}

	public void setDir_etablissement(DirEtablissement dir_etablissement) {
		this.dir_etablissement = dir_etablissement;
	}
}