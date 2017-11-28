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
	
	public Probleme getProblemeById(int id) {
		TypedQuery<Probleme> q = em.createQuery("select p from Probleme p where p.idProbleme=:id", Probleme.class);
		Probleme personne = q.getSingleResult();
		return personne;
	}
	
	public List<Probleme> getProblemeByPersonne(int idPersonne) {
		TypedQuery<Probleme> q = em.createQuery("select p from Probleme p where p.idPersonne=:idPersonne", Probleme.class);
		List<Probleme> list = q.getResultList();
		return list;
	}
	
	public List<Probleme> getProblemeByStatus(int idStatus) {
		TypedQuery<Probleme> q = em.createQuery("select p from Probleme p where p.idStatus=:idStatus", Probleme.class);
		List<Probleme> list = q.getResultList();
		return list;
	}
}
