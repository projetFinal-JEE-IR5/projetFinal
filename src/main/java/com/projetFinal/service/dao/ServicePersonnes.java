package com.projetFinal.service.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projetFinal.model.dao.DirEtablissementDAO;
import com.projetFinal.model.dao.DirEtudesDAO;
import com.projetFinal.model.dao.EtudiantDAO;
import com.projetFinal.model.metier.DirEtablissement;
import com.projetFinal.model.metier.DirEtudes;
import com.projetFinal.model.metier.Etudiant;

@Repository
@Transactional
public class ServicePersonnes {
	@PersistenceContext
	EntityManager em;

	@Autowired
	private DirEtablissementDAO dirEtablissementDAO;

	@Autowired
	private DirEtudesDAO dirEtudesDAO;

	@Autowired
	private EtudiantDAO etudiantDAO;

	public String trouverTypePersonne(String login) {
		String typePersonne = null;
		if (dirEtablissementDAO.estDirEtablissement(login)) {
			typePersonne = "dirEtablissement";
		} else if (dirEtudesDAO.estDirEtudes(login)) {
			typePersonne = "dirEtudes";
		} else if (etudiantDAO.estEtudiant(login)) {
			typePersonne = "etudiant";
		}
		return typePersonne;
	}

	public Object getPersonnebyLoginPassword(String login, String password, String typePersonne) {
		Object personne = null;
		if (typePersonne == "dirEtablissement") {
			personne = (DirEtablissement) dirEtablissementDAO.verifierLoginPassword(login, password);
		} else if (typePersonne == "dirEtudes") {
			personne = (DirEtudes) dirEtudesDAO.verifierLoginPassword(login, password);
		} else if (typePersonne == "etudiant") {
			personne = (Etudiant) etudiantDAO.verifierLoginPassword(login, password);
		}
		return personne;
	}
	public Object getPersonne(Integer id, String typePersonne) {
		Object personne = null;
		if (typePersonne == "dirEtablissement") {
			personne = (DirEtablissement) dirEtablissementDAO.getDirEtablissementById(id);
		} else if (typePersonne == "dirEtudes") {
			personne = (DirEtudes) dirEtudesDAO.getDirEtudesById(id);
		} else if (typePersonne == "etudiant") {
			personne = (Etudiant) etudiantDAO.getEtudiantById(id);
		}
		return personne;
	}
}
