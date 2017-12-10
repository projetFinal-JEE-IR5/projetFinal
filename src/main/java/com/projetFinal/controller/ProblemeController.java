package com.projetFinal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projetFinal.model.dao.PersonneDAO;
import com.projetFinal.model.dao.ProblemeDAO;
import com.projetFinal.model.dao.StatusDAO;
import com.projetFinal.model.metier.Personne;
import com.projetFinal.model.metier.Probleme;
import com.projetFinal.model.metier.Status;

@Controller
@RequestMapping("/problemes")
public class ProblemeController {
	
	@Autowired
	private ProblemeDAO problemeDAO;
	
	@Autowired
	private PersonneDAO personneDAO;
	
	@Autowired
	private StatusDAO statusDAO;
	
	@Autowired
	SessionId session;
	
	//@Autowired
	//private ServiceProbleme sp;

	@GetMapping("/afficherProblemesEtu")
	public String afficherProblemesEtu(Map<String, Object> model) {
		//sp.maMethode();		
		List<Probleme> listProblemes = problemeDAO.getAllProblemes();
		/*
		for (Probleme probleme : listProblemes) {
			String dateHeure=Long.toString(probleme.getDateHeureProbleme());
			dateHeure=dateHeure.substring(0, 2)+"/"+dateHeure.substring(2, 4)+"/"+dateHeure.substring(4, 6)+" "+dateHeure.substring(6, 7)+":"+dateHeure.substring(7, 9)+":"+dateHeure.substring(9, 11);
		*/
		model.put("listProblemes", listProblemes);
		return "/afficherProblemesEtu";
	}
	
	@GetMapping("/afficherProblemesDirEtu")
	public String afficherProblemesDirEtu(Map<String, Object> model) {
		//sp.maMethode();		
		List<Probleme> listProblemes = problemeDAO.getAllProblemes();
		model.put("listProblemes", listProblemes);
		return "/afficherProblemesDirEtu";
	}
	
	@GetMapping("/afficherProblemesDirEta")
	public String afficherProblemesDirEta(Map<String, Object> model) {
		//sp.maMethode();		
		List<Probleme> listProblemes = problemeDAO.getAllProblemes();
		model.put("listProblemes", listProblemes);
		return "/afficherProblemesDirEta";
	}
	
	@GetMapping("/ajouterProbleme")
	public String ajouterProbleme() {
		return "/ajouterProbleme";
	}
	
	@PostMapping("/ajouterProbleme")
	public String soumettreProbleme(@RequestParam Map<String, String> formValues, Map<String, Object> model) {
		String objet = formValues.get("objet");
		String contenu = formValues.get("contenu");
		Personne personne = personneDAO.getPersonneById(session.getCurrentUserId());
		Status status = statusDAO.getStatusById(1);
		String format = "ddMMyyHmmss"; 
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date date = new java.util.Date(); 
		long dateHeureProbleme = Long.valueOf(formater.format(date));
		//long dateHeureProbleme = 1509380153;
		Probleme unProbleme = new Probleme(null, objet, contenu, status, personne, dateHeureProbleme);
		problemeDAO.addProbleme(unProbleme);
		//on affiche la nouvelle liste de pb
		List<Probleme> listProblemes = problemeDAO.getAllProblemes();
		model.put("listProblemes", listProblemes);
		return "/afficherProblemesEtu";
	}	
	
	@GetMapping("/supprProblemesResolus")
	public String supprimerProblemesResolus(Map<String, Object> model) {		
		problemeDAO.deleteProblemesResolus();
		List<Probleme> listProblemes = problemeDAO.getAllProblemes();
		model.put("listProblemes", listProblemes);
		return "/afficherProblemesDir";
	}
	
	@GetMapping("/limiterNbPbDirEtu")
	public String limiterNbPbDirEtu() {
		return "/limiterNbPbDirEtu";
	}
	
	@PostMapping("/validerLimNbPbDirEtu")
	public String validerLimNbPbDirEtu(@RequestParam Map<String, String> formValues, Map<String, Object> model) {
		Integer nbPb = Integer.parseInt(formValues.get("nbPb"));
		return "/afficherProblemesDirEtu";
	}	
	
	@GetMapping("/limiterNbPbDirEta")
	public String limiterNbPbDirEta() {
		return "/limiterNbPbDirEta";
	}
	
	@PostMapping("/validerLimNbPbDirEta")
	public String validerLimNbPbDirEta(@RequestParam Map<String, String> formValues, Map<String, Object> model) {
		Integer nbPb = Integer.parseInt(formValues.get("nbPb"));
		return "/afficherProblemesDirEta";
	}	
}
