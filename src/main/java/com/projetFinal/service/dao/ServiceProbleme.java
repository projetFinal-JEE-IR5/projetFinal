package com.projetFinal.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projetFinal.model.dao.EtudiantDAO;
import com.projetFinal.model.dao.ProblemeDAO;
import com.projetFinal.model.dao.StatusDAO;
import com.projetFinal.model.metier.Etudiant;
import com.projetFinal.model.metier.Probleme;
import com.projetFinal.model.metier.Status;

@Repository
@Transactional
public class ServiceProbleme {
	@PersistenceContext
	EntityManager em;

	@Autowired
	private ProblemeDAO problemeDAO;
	
	@Autowired
	private EtudiantDAO etudiantDAO;
	
	@Autowired
	private StatusDAO statusDAO;

	public List<Probleme> getAllProblemes() {
		List<Probleme> listeProblemes = problemeDAO.getAllProblemes();
		return listeProblemes;
	}
	
	public Etudiant getEtudiantById(Integer id) {
		Etudiant etudiant = etudiantDAO.getEtudiantById(id);
		return etudiant;
	}
	
	public Status getStatusById(int id) {
		Status status  = statusDAO.getStatusById(id);
		return status;
	}
	
	public void setNbPbAutorise(Integer nb) {
		etudiantDAO.setNbPbAutorise(nb);
	}
	
	public void addProbleme(Probleme unProbleme) {
		problemeDAO.addProbleme(unProbleme);
	}
	
	public void addVoteProbleme(Integer idProbleme) {
		problemeDAO.addVoteProbleme(idProbleme);
	}
	
	public void deleteProblemesResolus() {
		problemeDAO.deleteProblemesResolus();
	}
	
	
}
