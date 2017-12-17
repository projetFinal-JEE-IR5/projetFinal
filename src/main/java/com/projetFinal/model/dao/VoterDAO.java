package com.projetFinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.Voter;
import com.projetFinal.model.metier.VoterPK;

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
	
	public Voter getVoterById(int id) {
		TypedQuery<Voter> q = em.createQuery("select s from Voter s where s.idVoter=:id", Voter.class);
		q.setParameter("id", id);
		Voter voter = q.getSingleResult();
		return voter;
	}
	
	public void addVoter(Voter unVoter) {
		em.persist(unVoter);
	}
	
	public void supprVoterById(Integer id) {
		Voter voter = em.find(Voter.class, id);
		em.remove(voter);
	}
	
	public Voter getVoterById(VoterPK pVoterPK) {
	    return em.find(Voter.class,pVoterPK);
	}
	
//	public Voter deleteVoter(Integer id) {
//		Voter voter = ?? getVoterById(id);
//		return em.remove(voter);
//	}
}
