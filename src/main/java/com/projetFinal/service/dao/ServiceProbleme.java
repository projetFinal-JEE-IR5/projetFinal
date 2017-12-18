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
import com.projetFinal.model.dao.VoterDAO;
import com.projetFinal.model.metier.Etudiant;
import com.projetFinal.model.metier.Probleme;
import com.projetFinal.model.metier.Recevoir;
import com.projetFinal.model.metier.Status;
import com.projetFinal.model.metier.Voter;

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
	
	@Autowired
	private VoterDAO voterDAO;

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
	
	public void addVoter(Voter vote) {
		voterDAO.addVoter(vote);
	}
	
	public void addVoteProbleme(Integer idProbleme) {
		problemeDAO.addVoteProbleme(idProbleme);
	}
	
	public List<Probleme> getProblemesResolus(){
		List<Probleme> listeProblemes = problemeDAO.getProblemesResolus();
		return listeProblemes;
	}
	
	public void deleteProblemesResolus() {
		problemeDAO.deleteProblemesResolus();
	}
	
	public List<Voter> getVotesByIdProbleme(Integer idProbleme) {
		List<Voter> listeVotes = voterDAO.getVotesByIdProbleme(idProbleme);
		return listeVotes;
	}
	
	public Voter getVoterByIdEtuIdPb(Integer idEtudiant, Integer idProbleme) {
		Voter vote = voterDAO.getVoterByIdEtuIdPb(idEtudiant, idProbleme);
		return vote;
	}
	
	public void supprVotes(List<Voter> listeVotes) {
		voterDAO.supprVotes(listeVotes);
	}
}
