package com.projetFinal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projetFinal.model.metier.Etudiant;
import com.projetFinal.model.metier.Probleme;
import com.projetFinal.model.metier.Status;
import com.projetFinal.model.metier.Voter;
import com.projetFinal.model.metier.VoterPK;
import com.projetFinal.service.dao.ServiceProbleme;

@Controller
@RequestMapping("/problemes")
public class ProblemeController {
	String template="/fragments/template";
	
	@Autowired
	Session session;
	
	@Autowired
	private ServiceProbleme serviceProbleme;

	@GetMapping("/afficherProblemesEtu")
	public String afficherProblemesEtu(Map<String, Object> model) {
		List<Probleme> listProblemes = serviceProbleme.getAllProblemes();
		model.put("listProblemes", listProblemes);
		String action = "afficherProblemes";
		model.put("action", action);
		String currentTypePersonne = session.getCurrentTypePersonne();
		model.put("typePersonne", currentTypePersonne);
		return template;
	}
	
	@GetMapping("/afficherProblemesDirEtu")
	public String afficherProblemesDirEtu(Map<String, Object> model) {
		List<Probleme> listProblemes = serviceProbleme.getAllProblemes();
		model.put("listProblemes", listProblemes);
		String action = "afficherProblemes";
		model.put("action", action);
		String currentTypePersonne = session.getCurrentTypePersonne();
		model.put("typePersonne", currentTypePersonne);
		return template;
	}
	
	@GetMapping("/afficherProblemesDirEta")
	public String afficherProblemesDirEta(Map<String, Object> model) {
		List<Probleme> listProblemes = serviceProbleme.getAllProblemes();
		model.put("listProblemes", listProblemes);
		String action = "afficherProblemes";
		model.put("action", action);
		String currentTypePersonne = session.getCurrentTypePersonne();
		model.put("typePersonne", currentTypePersonne);
		return template;
	}
	
	@GetMapping("/ajouterProbleme")
	public String ajouterProbleme(Map<String, Object> model) {
		String action = "ajouterProbleme";
		model.put("action", action);
		String currentTypePersonne = session.getCurrentTypePersonne();
		model.put("typePersonne", currentTypePersonne);
		return template;
	}
	
	@PostMapping("/ajouterProbleme")
	public String soumettreProbleme(@RequestParam Map<String, String> formValues, Map<String, Object> model) {
		String objet = formValues.get("objet");
		String contenu = formValues.get("contenu");
		Etudiant etudiant = serviceProbleme.getEtudiantById(session.getCurrentUserId());
		Status status = serviceProbleme.getStatusById(1);
		String format = "ddMMyyHHmmss"; 
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date date = new java.util.Date(); 
		long dateHeureProbleme = Long.valueOf(formater.format(date));
		//long dateHeureProbleme = 111217154156;
		Probleme unProbleme = new Probleme(null, objet, contenu, status, etudiant, dateHeureProbleme, 0);
		serviceProbleme.addProbleme(unProbleme);
		//on affiche la nouvelle liste de pb
		List<Probleme> listProblemes = serviceProbleme.getAllProblemes();
		model.put("listProblemes", listProblemes);
		String action = "afficherProblemes";
		model.put("action", action);
		String currentTypePersonne = session.getCurrentTypePersonne();
		model.put("typePersonne", currentTypePersonne);
		return template;
	}	
	
	@GetMapping("/supprProblemesResolus")
	public String supprimerProblemesResolus(Map<String, Object> model) {	
		//TODO corriger : il y a un probleme de contrainte
		List<Probleme> listeProblemesResolus = serviceProbleme.getProblemesResolus();
		for (Probleme probleme : listeProblemesResolus) {
			List<Voter> listeVotes = serviceProbleme.getVotesByIdProbleme(probleme.getIdProbleme());
			serviceProbleme.supprVotes(listeVotes);
		}
		serviceProbleme.deleteProblemesResolus();
		List<Probleme> listProblemes = serviceProbleme.getAllProblemes();
		model.put("listProblemes", listProblemes);
		String action = "afficherProblemes";
		model.put("action", action);
		String currentTypePersonne = session.getCurrentTypePersonne();
		model.put("typePersonne", currentTypePersonne);
		return template;
	}
	
	@GetMapping("/limiterNbPbDirEtu")
	public String limiterNbPbDirEtu(Map<String, Object> model) {
		String action = "limiterNbProb";
		model.put("action", action);
		String currentTypePersonne = session.getCurrentTypePersonne();
		model.put("typePersonne", currentTypePersonne);
		return template;
	}
	
	@PostMapping("/limiterNbPbDirEtu")
	public String validerLimNbPbDirEtu(@RequestParam Map<String, String> formValues, Map<String, Object> model) {
		Integer nbPb = Integer.parseInt(formValues.get("nbPb"));
		serviceProbleme.setNbPbAutorise(nbPb);
		model.put("message", "Limite validée");
		String action = "limiterNbProb";
		model.put("action", action);
		String currentTypePersonne = session.getCurrentTypePersonne();
		model.put("typePersonne", currentTypePersonne);
		return template;
	}
	
	@GetMapping("/limiterNbPbDirEta")
	public String limiterNbPbDirEta(Map<String, Object> model) {
		String action = "limiterNbProb";
		model.put("action", action);
		String currentTypePersonne = session.getCurrentTypePersonne();
		model.put("typePersonne", currentTypePersonne);
		return template;
	}
	
	@PostMapping("/limiterNbPbDirEta")
	public String validerLimNbPbDirEta(@RequestParam Map<String, String> formValues, Map<String, Object> model) {
		Integer nbPb = Integer.parseInt(formValues.get("nbPb"));
		serviceProbleme.setNbPbAutorise(nbPb);
		model.put("message", "Limite validée");
		String action = "limiterNbProb";
		model.put("action", action);
		String currentTypePersonne = session.getCurrentTypePersonne();
		model.put("typePersonne", currentTypePersonne);
		return template;
	}	
	
	@PostMapping("/afficherProblemesEtu")
	public String addVoteProbleme(@RequestParam Map<String, String> formValues, Map<String, Object> model) {
		Integer idProbleme = Integer.parseInt(formValues.get("idProbleme"));
		Integer idEtudiant = session.getCurrentUserId();
		try {
			Voter vote = serviceProbleme.getVoterByIdEtuIdPb(idEtudiant, idProbleme);
			model.put("message", "vous ne pouvez voter qu'une seule fois pour un problème");
		}catch (Exception e) {
			serviceProbleme.addVoter(new Voter(new VoterPK(idEtudiant,idProbleme)));
			serviceProbleme.addVoteProbleme(idProbleme);
		}
		List<Probleme> listProblemes = serviceProbleme.getAllProblemes();
		model.put("listProblemes", listProblemes);
		String action = "afficherProblemes";
		model.put("action", action);
		String currentTypePersonne = session.getCurrentTypePersonne();
		model.put("typePersonne", currentTypePersonne);
		return template;
	}
}
