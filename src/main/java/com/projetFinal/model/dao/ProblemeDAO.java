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

	public void addProbleme(Probleme unProbleme) {
		em.persist(unProbleme);
	}
	
	public void addVoteProbleme(Integer idProbleme) {
		Probleme probleme = em.find(Probleme.class, idProbleme);
		probleme.setNbVote(probleme.getNbVote()+1);
	}
		
	public void deleteProblemesResolus() {
		TypedQuery<Probleme> q = em.createQuery("select p from Probleme p join fetch p.status s where s.idStatus=2", Probleme.class);
		List<Probleme> list = q.getResultList();
		for (Probleme probleme : list) {
			em.remove(probleme);
		}
	}
}
