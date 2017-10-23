package com.projetFinal.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.Personne;

@Repository
@Transactional
public class PersonneDAO {
	@PersistenceContext
	EntityManager em;

	public Personne readFirst() {
		return null;
		//return em.find(Personne.class, );
	}
}
