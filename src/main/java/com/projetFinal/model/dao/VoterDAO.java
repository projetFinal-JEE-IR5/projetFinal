package com.projetFinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.Voter;

@Repository
@Transactional
public class VoterDAO {
	@PersistenceContext
	EntityManager em;

	public List<Voter> getAllVoter() {
		TypedQuery<Voter> q = em.createQuery("select s from Voter s", Voter.class);
		List<Voter> list = q.getResultList();
		return list;
	}
	
	public Voter getVoterById(Integer id) {
		TypedQuery<Voter> q = em.createQuery("select s from Voter s where s.idVoter=:id", Voter.class);
		q.setParameter("id", id);
		Voter voter = q.getSingleResult();
		return voter;
	}
	
	public Voter getVoterByIdEtuIdPb(Integer idEtudiant, Integer idProbleme) {
		TypedQuery<Voter> q = em.createQuery("select s from Voter s where s.idVoter.idEtudiant=:idEtudiant and s.idVoter.idProbleme=:idProbleme", Voter.class);
		q.setParameter("idEtudiant", idEtudiant);
		q.setParameter("idProbleme", idProbleme);
		Voter voter = q.getSingleResult();
		return voter;
	}
	
	public void addVoter(Voter vote) {
		em.persist(vote);
	}
	
	public void supprVotes(List<Voter> listeVotes) {
		for (Voter vote : listeVotes) {
			em.remove(vote);
		}
	}
	
	public List<Voter> getVotesByIdProbleme(Integer idProbleme) {
		TypedQuery<Voter> q = em.createQuery("select v from Voter v where v.idVoter.idProbleme=:idProbleme", Voter.class);
		q.setParameter("idProbleme", idProbleme);
		List<Voter> listeVotes = q.getResultList();
		return listeVotes;
	}
}
