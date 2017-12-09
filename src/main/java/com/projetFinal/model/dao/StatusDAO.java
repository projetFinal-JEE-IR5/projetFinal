package com.projetFinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.Filiere;
import com.projetFinal.model.metier.Personne;
import com.projetFinal.model.metier.Status;

@Repository
@Transactional
public class StatusDAO {
	@PersistenceContext
	EntityManager em;

	public List<Status> getAllStatus() {
		TypedQuery<Status> q = em.createQuery("select s from Status s", Status.class);
		List<Status> list = q.getResultList();
		return list;
	}
	
	public Status getStatusById(int id) {
		TypedQuery<Status> q = em.createQuery("select s from Status s where s.idStatus=:id", Status.class);
		q.setParameter("id", id);
		Status status = q.getSingleResult();
		return status;
	}
}
