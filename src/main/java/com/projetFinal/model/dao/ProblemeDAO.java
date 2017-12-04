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
		q.setParameter("id", id);
		Probleme probleme = q.getSingleResult();
		return probleme;
	}
	
	public List<Probleme> getProblemesByPersonne(int idPersonne) {
		TypedQuery<Probleme> q = em.createQuery("select p from Probleme p where p.idPersonne=:idPersonne", Probleme.class);
		q.setParameter("idPersonne", idPersonne);
		List<Probleme> list = q.getResultList();
		return list;
	}
	
	public List<Probleme> getProblemesByStatus(int idStatus) {
		TypedQuery<Probleme> q = em.createQuery("select p from Probleme p where p.idStatus=:idStatus", Probleme.class);
		q.setParameter("idStatus", idStatus);
		List<Probleme> list = q.getResultList();
		return list;
	}
}
