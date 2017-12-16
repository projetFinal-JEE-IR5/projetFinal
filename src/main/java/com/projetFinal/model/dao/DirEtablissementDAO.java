package com.projetFinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.DirEtablissement;


@Repository
@Transactional
public class DirEtablissementDAO {
	@PersistenceContext
	EntityManager em;

	public List<DirEtablissement> getAllDirEtablissement() {
		TypedQuery<DirEtablissement> q = em.createQuery("select d from DirEtablissement d", DirEtablissement.class);
		List<DirEtablissement> list = q.getResultList();
		return list;
	}
	
	public DirEtablissement getDirEtablissementById(Integer id) {
		TypedQuery<DirEtablissement> q = em.createQuery("select d from DirEtablissement d where d.idDirEtablissement=:id", DirEtablissement.class);
		q.setParameter("id", id);
		DirEtablissement etudiant = q.getSingleResult();
		return etudiant;
	}
	
	public boolean estDirEtablissement(String login) {
		boolean verif = false;
		TypedQuery<DirEtablissement> q = em.createQuery("select d from DirEtablissement d where d.login=:login", DirEtablissement.class);
		q.setParameter("login", login);
//		DirEtablissement dirEtablissement = q.getSingleResult();
//		if(dirEtablissement != null) {
//			verif = true;
//		}
		
		/*
		ici on change getSingleResult par getResultList 
		parce que lorsque getSingleResult est null, 
		il renvoie directement une exception et arrete l'application
		*/
		
		List<DirEtablissement> results = q.getResultList();
		if (!results.isEmpty()) {
			verif = true;
		}
		return verif;
	}
	
	public DirEtablissement verifierLoginPassword(String login, String password) {
		TypedQuery<DirEtablissement> q = em.createQuery("select d from DirEtablissement d where d.login=:login and d.password=:password", DirEtablissement.class);
		q.setParameter("login", login);
		q.setParameter("password", password);
		DirEtablissement dirEtablissement = q.getSingleResult();
		return dirEtablissement;
	}
}
