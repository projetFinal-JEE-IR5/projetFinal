package com.projetFinal.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.Role;

@Repository
@Transactional
public class RoleDAO {
	@PersistenceContext
	EntityManager em;

	public Role readFirst() {
		return null;
		//return em.find(Personne.class, );
	}
}
