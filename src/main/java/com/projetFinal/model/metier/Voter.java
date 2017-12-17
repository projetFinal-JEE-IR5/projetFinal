package com.projetFinal.model.metier;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Voter {
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name = "id.etudiant", column = @Column(name = "id_etudiant")),
		@AttributeOverride(name = "id.probleme", column = @Column(name = "id_probleme")) })
	private VoterPK idVoter;

	public Voter() {
	}

	public Voter(VoterPK idVoter) {
		super();
		this.idVoter = idVoter;
	}

	public VoterPK getIdVoter() {
		return idVoter;
	}

	public void setIdVoter(VoterPK idVoter) {
		this.idVoter = idVoter;
	}
}