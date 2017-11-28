package com.projetFinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.Filiere;

@Repository
@Transactional
public class FiliereDAO {
	@PersistenceContext
	EntityManager em;

	public List<Filiere> getAllFiliere() {
		TypedQuery<Filiere> q = em.createQuery("select f from Filiere f", Filiere.class);
		List<Filiere> list = q.getResultList();
		return list;
	}
	
	public Filiere getFiliereById(int id) {
		TypedQuery<Filiere> q = em.createQuery("select f from Filiere f where f.idFiliere=:id", Filiere.class);
		Filiere filiere = q.getSingleResult();
		return filiere;
	}
}
