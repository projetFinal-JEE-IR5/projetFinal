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

	public List<Probleme> getAllProblemes() {
		TypedQuery<Probleme> q = em.createQuery("select p from Probleme p", Probleme.class);
		List<Probleme> list = q.getResultList();
		return list;
	}

	void addProbleme(Probleme unProbleme) {
		 em.getTransaction().begin();
		 em.persist(unProbleme);
		 em.getTransaction().commit();
	}
		
	void deleteProblemeResolu(int idStatus) {
		 TypedQuery<Probleme> q = em.createQuery("select p from Probleme p where p.idStatus=:idStatus", Probleme.class);
		 Probleme unProbleme = q.getSingleResult();
		 em.getTransaction().begin();
		 em.remove(unProbleme);
		 em.getTransaction().commit();
		 }
	}
