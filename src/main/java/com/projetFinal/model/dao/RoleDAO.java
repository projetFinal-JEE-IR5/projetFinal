package com.projetFinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.Role;

@Repository
@Transactional
public class RoleDAO {
	@PersistenceContext
	EntityManager em;

	public List<Role> readFirst() {
		TypedQuery<Role> q = em.createQuery("select r from Role r", Role.class);
		List<Role> list = q.getResultList();
		return list;
	}
}
