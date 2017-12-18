package com.projetFinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.Recevoir;
import com.projetFinal.model.metier.RecevoirPK;

@Repository
@Transactional
public class RecevoirDAO {
	@PersistenceContext
	EntityManager em;

	public List<Recevoir> getAllRecevoir() {
		TypedQuery<Recevoir> q = em.createQuery("select r from Recevoir r", Recevoir.class);
		List<Recevoir> list = q.getResultList();
		return list;
	}
	
	public Recevoir getRecevoirById(int id) {
		TypedQuery<Recevoir> q = em.createQuery("select r from Recevoir r where r.idRecevoir=:id", Recevoir.class);
		q.setParameter("id", id);
		Recevoir recevoir = q.getSingleResult();
		return recevoir;
	}
	
	public void addRecevoir(Recevoir unRecevoir) {
		em.persist(unRecevoir);
	}
	
	public void supprRecepteurs(List<Recevoir> listeRecepteurs) {
		for (Recevoir recepteur : listeRecepteurs) {
			em.remove(recepteur);
		}
	}
	
	public List<Recevoir> getRecepteursByIdNotif(Integer idNotif) {
		TypedQuery<Recevoir> q = em.createQuery("select r from Recevoir r where r.idRecevoir.idNotification=:idNotif", Recevoir.class);
		q.setParameter("idNotif", idNotif);
		List<Recevoir> listeRecepteurs = q.getResultList();
		return listeRecepteurs;
	}
}
