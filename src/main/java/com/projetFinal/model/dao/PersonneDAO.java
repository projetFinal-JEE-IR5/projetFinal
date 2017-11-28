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
	
	public Personne getPersonneById(Integer id) {
		TypedQuery<Personne> q = em.createQuery("select p from Personne p where p.idPersonne=:id", Personne.class);
		q.setParameter("id", id);
		Personne personne = q.getSingleResult();
		return personne;
	}
	
	public List<Personne> getPersonneByRole(Integer idRole) {
		TypedQuery<Personne> q = em.createQuery("select p from Personne p where p.idRole=:idRole", Personne.class);
		List<Personne> listePersonne = q.getResultList();
		return listePersonne;
	}

	public void addPersonne(Personne personne) {
		em.persist(personne); // Use EntityManager
	}

	public Personne getPersonneById(long id) {
		return em.find(Personne.class, id);
	}

	public void savePersonne(Personne personne) {
		em.merge(personne);
	}
}
