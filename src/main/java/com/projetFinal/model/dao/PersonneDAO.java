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
	
	public Personne getPersonneById(int id) {
		TypedQuery<Personne> q = em.createQuery("select p from Personne p where p.idPersonne=:id", Personne.class);
		Personne personne = q.getSingleResult();
		return personne;
	}
	
	public List<Personne> getPersonneByRole(int idRole) {
		TypedQuery<Personne> q = em.createQuery("select p from Personne p where p.idRole=:idRole", Personne.class);
		List<Personne> listePersonne = q.getResultList();
		return listePersonne;
	}
	
	public List<Personne> getPersonneByFiliere(int idFiliere) {
		TypedQuery<Personne> q = em.createQuery("select p from Personne p where p.idFiliere=:idFiliere", Personne.class);
		List<Personne> listePersonne = q.getResultList();
		return listePersonne;
	}
}
