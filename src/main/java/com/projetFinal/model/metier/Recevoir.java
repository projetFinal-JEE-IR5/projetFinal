package com.projetFinal.model.metier;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Recevoir {

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "id.notification", column = @Column(name = "id_notification")),
			@AttributeOverride(name = "id.etudiant", column = @Column(name = "id_personne")) })
	private RecevoirPK id;

	public Recevoir() {
	}

	public Recevoir(RecevoirPK id) {
		super();
		this.id = id;
	}

	public RecevoirPK getId() {
		return id;
	}

	public void setId(RecevoirPK id) {
		this.id = id;
	}
}
