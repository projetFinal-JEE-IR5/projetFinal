package com.projetFinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.DirEtudes;


@Repository
@Transactional
public class DirEtudesDAO {
	@PersistenceContext
	EntityManager em;

	public List<DirEtudes> getAllDirEtudes() {
		TypedQuery<DirEtudes> q = em.createQuery("select d from DirEtudes d", DirEtudes.class);
		List<DirEtudes> list = q.getResultList();
		return list;
	}
	
	public DirEtudes getDirEtudesById(Integer id) {
		TypedQuery<DirEtudes> q = em.createQuery("select d from DirEtudes d where d.idDirEtudes=:id", DirEtudes.class);
		q.setParameter("id", id);
		DirEtudes dirEtudes = q.getSingleResult();
		return dirEtudes;
	}
	
	public List<DirEtudes> getDirEtudesByFiliere(int idFiliere) {
		TypedQuery<DirEtudes> q = em.createQuery("select d from DirEtudes d where d.idFiliere=:idFiliere", DirEtudes.class);
		List<DirEtudes> listeDirEtudes = q.getResultList();
		return listeDirEtudes;
	}
	
	public boolean estDirEtudes(String login) {
		boolean verif = false;
		TypedQuery<DirEtudes> q = em.createQuery("select d from DirEtudes d where d.login=:login", DirEtudes.class);
		q.setParameter("login", login);
//		DirEtudes dirEtudes = q.getSingleResult();
//		if(dirEtudes != null) {
//			verif = true;
//		}
		
		/*
		ici on change getSingleResult par getResultList 
		parce que lorsque getSingleResult est null, 
		il renvoie directement une exception et arrete l'application
		*/
		
		List<DirEtudes> results = q.getResultList();
		if (!results.isEmpty()) {
			verif = true;
		}
		return verif;
	}
	
	public DirEtudes verifierLoginPassword(String login, String password) {
		TypedQuery<DirEtudes> q = em.createQuery("select d from DirEtudes d where d.login=:login and d.password=:password", DirEtudes.class);
		q.setParameter("login", login);
		q.setParameter("password", password);
		DirEtudes dirEtudes = q.getSingleResult();
		return dirEtudes;
	}
}
