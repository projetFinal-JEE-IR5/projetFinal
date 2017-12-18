package com.projetFinal.model.metier;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Recevoir {
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name = "id.notification", column = @Column(name = "id_notification")),
		@AttributeOverride(name = "id.etudiant", column = @Column(name = "id_etudiant")) })
	private RecevoirPK idRecevoir;

	public Recevoir() {
	}

	public Recevoir(RecevoirPK idRecevoir) {
		super();
		this.idRecevoir = idRecevoir;
	}
	
	public RecevoirPK getIdRecevoir() {
		return idRecevoir;
	}

	public void setIdRecevoir(RecevoirPK idRecevoir) {
		this.idRecevoir = idRecevoir;
	}
	
//	@Id
//	private Integer idNotification;
//	@Id
//	private Integer idEtudiant;
//	
//	public Recevoir(Integer idNotification, Integer idEtudiant) {
//		super();
//		this.idNotification = idNotification;
//		this.idEtudiant = idEtudiant;
//	}
//	
//	public Integer getIdNotification() {
//		return idNotification;
//	}
//
//	public void setIdNotification(Integer idNotification) {
//		this.idNotification = idNotification;
//	}
//
//	public Integer getIdEtudiant() {
//		return idEtudiant;
//	}
//
//	public void setIdEtudiant(Integer idEtudiant) {
//		this.idEtudiant = idEtudiant;
//	}
}