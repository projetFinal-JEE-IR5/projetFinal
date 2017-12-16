package com.projetFinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.Probleme;

@Repository
@Transactional
public class ProblemeDAO {
	@PersistenceContext
	EntityManager em;

	public List<Probleme> getAllProblemes() {
		TypedQuery<Probleme> q = em.createQuery("select p from Probleme p", Probleme.class);
		List<Probleme> list = q.getResultList();
		return list;
	}
	
	public Integer getNbVotesProbleme(Integer idProbleme) {
		Query q = em.createQuery("select count(id_probleme) from voter v where v.id_probleme=:idProbleme");
		q.setParameter("idProbleme", idProbleme);
		Integer nbVotes = (Integer) q.getSingleResult();
		return nbVotes;
	}

	public void addProbleme(Probleme unProbleme) {
		em.persist(unProbleme);
	}
		
	public void deleteProblemesResolus() {
		TypedQuery<Probleme> q = em.createQuery("select p from Probleme p inner join Status s on p.idStatus=s.idStatus inner join Voter v on p.idProbleme=v.idProbleme where s.idStatus=2", Probleme.class);
		List<Probleme> list = q.getResultList();
		for (Probleme probleme : list) {
			em.remove(probleme);
		}
	}
}
