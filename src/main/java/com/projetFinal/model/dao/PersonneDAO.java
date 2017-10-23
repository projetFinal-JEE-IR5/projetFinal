package com.projetFinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.Personne;

@Repository
@Transactional
public class PersonneDAO {
	@PersistenceContext
	EntityManager em;

	public List<Personne> getAllPersonne() {
		TypedQuery<Personne> q = em.createQuery("select p from Personne p", Personne.class);
		List<Personne> list = q.getResultList();
		return list;
	}

	public void addStudent(Personne personne) {
		em.persist(personne); // Use EntityManager
	}

	public Personne getPersonneById(long id) {
		return em.find(Personne.class, id);
	}

	public void saveStudent(Personne personne) {
		em.merge(personne);
	}
}
