package com.projetFinal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projetFinal.model.dao.EtudiantDAO;
import com.projetFinal.model.dao.ProblemeDAO;
import com.projetFinal.model.dao.StatusDAO;
import com.projetFinal.model.metier.Etudiant;
import com.projetFinal.model.metier.Probleme;
import com.projetFinal.model.metier.Status;

@Controller
@RequestMapping("/problemes")
public class ProblemeController {
	
	@Autowired
	private ProblemeDAO problemeDAO;
	
	@Autowired
	private EtudiantDAO etudiantDAO;
	
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
		model.put("listProblemes", listProblemes);
		return "/afficherProblemesEtu";
	}
	
	@GetMapping("/afficherProblemesDir")
	public String afficherProblemesDir(Map<String, Object> model) {
		//sp.maMethode();		
		List<Probleme> listProblemes = problemeDAO.getAllProblemes();
		model.put("listProblemes", listProblemes);
		return "/afficherProblemesDir";
	}
	
	@GetMapping("/ajouterProbleme")
	public String ajouterProbleme() {
		return "/ajouterProbleme";
	}
	
	@PostMapping("/ajouterProbleme")
	public String soumettreProbleme(@RequestParam Map<String, String> formValues, Map<String, Object> model) {
		String objet = formValues.get("objet");
		String contenu = formValues.get("contenu");
		Etudiant etudiant = etudiantDAO.getEtudiantById(session.getCurrentUserId());
		Status status = statusDAO.getStatusById(1);
		String format = "ddMMyyHmmss"; 
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date date = new java.util.Date(); 
		long dateHeureProbleme = Long.valueOf(formater.format(date));
		//long dateHeureProbleme = 1509380153;
		Probleme unProbleme = new Probleme(null, objet, contenu, status, etudiant, dateHeureProbleme);
		problemeDAO.addProbleme(unProbleme);
		//on affiche la nouvelle liste de pb
		List<Probleme> listProblemes = problemeDAO.getAllProblemes();
		model.put("listProblemes", listProblemes);
		return "/afficherProblemesEtu";
	}	
}
