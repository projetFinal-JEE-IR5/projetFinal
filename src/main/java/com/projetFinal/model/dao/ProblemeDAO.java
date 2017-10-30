package com.projetFinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.Probleme;

@Repository
@Transactional
public class ProblemeDAO {
	@PersistenceContext
	EntityManager em;

	public List<Probleme> getAllProbleme() {
		TypedQuery<Probleme> q = em.createQuery("select p from Probleme p", Probleme.class);
		List<Probleme> list = q.getResultList();
		return list;
	}

	public void addProbleme(Probleme probleme) {
		em.persist(probleme); // Use EntityManager
	}

	public Probleme getProblemeById(long id) {
		return em.find(Probleme.class, id);
	}

	public void saveProbleme(Probleme probleme) {
		em.merge(probleme);
	}
}
