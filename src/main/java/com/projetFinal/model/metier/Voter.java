package com.projetFinal.model.metier;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Voter {
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name = "id.etudiant", column = @Column(name = "id_etudiant")),
		@AttributeOverride(name = "id.probleme", column = @Column(name = "id_probleme")) })
	private VoterPK id;

	@Basic
	private long dateHeureVote;

	public Voter() {
	}

	public Voter(VoterPK id, long dateHeureVote) {
		super();
		this.id = id;
		this.dateHeureVote = dateHeureVote;
	}

	public VoterPK getId() {
		return id;
	}

	public void setId(VoterPK id) {
		this.id = id;
	}

	public long getDateHeureVote() {
		return dateHeureVote;
	}

	public void setDateHeureVote(long dateHeureVote) {
		this.dateHeureVote = dateHeureVote;
	}
}
