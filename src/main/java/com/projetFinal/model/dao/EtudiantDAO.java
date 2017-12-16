package com.projetFinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.Etudiant;

@Repository
@Transactional
public class EtudiantDAO {
	@PersistenceContext
	EntityManager em;

	public List<Etudiant> getAllEtudiant() {
		TypedQuery<Etudiant> q = em.createQuery("select e from Etudiant e", Etudiant.class);
		List<Etudiant> list = q.getResultList();
		return list;
	}

	public Etudiant getEtudiantById(Integer id) {
		TypedQuery<Etudiant> q = em.createQuery("select e from Etudiant e where e.idEtudiant=:id", Etudiant.class);
		q.setParameter("id", id);
		Etudiant etudiant = q.getSingleResult();
		return etudiant;
	}

	public List<Etudiant> getEtudiantByFiliere(int idFiliere) {
		TypedQuery<Etudiant> q = em.createQuery("select e from Etudiant e where e.idFiliere=:idFiliere",
				Etudiant.class);
		List<Etudiant> listeEtudiants = q.getResultList();
		return listeEtudiants;
	}

	public Etudiant verifierLoginPassword(String login, String password) {
		TypedQuery<Etudiant> q = em.createQuery("select e from Etudiant e where e.login=:login and e.password=:password", Etudiant.class);
		q.setParameter("login", login);
		q.setParameter("password", password);
		Etudiant etudiant = q.getSingleResult();
		return etudiant;
	}
	
	public boolean estEtudiant(String login) {
		boolean verif = false;
		TypedQuery<Etudiant> q = em.createQuery("select e from Etudiant e where e.login=:login", Etudiant.class);
		q.setParameter("login", login);
//		Etudiant etudiant = q.getSingleResult();
//		if(etudiant != null) {
//			verif = true;
//		}
		
		/*
		ici on change getSingleResult par getResultList 
		parce que lorsque getSingleResult est null, 
		il renvoie directement une exception et arrete l'application
		*/
		
		List<Etudiant> results = q.getResultList();
		if (!results.isEmpty()) {
			verif = true;
		}
		return verif;
	}
	
	public void setNbPbAutorise(Integer nb) {
		List<Etudiant> listeEtudiants = getAllEtudiant();
		for (Etudiant etudiant : listeEtudiants) {
			etudiant.setNbProbAutoriseJour(nb);
		}
	}
}
