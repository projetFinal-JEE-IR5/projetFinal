package com.projetFinal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetFinal.model.dao.PersonneDAO;
import com.projetFinal.model.dao.ProblemeDAO;
import com.projetFinal.model.metier.Personne;
import com.projetFinal.model.metier.Probleme;

@Controller
@RequestMapping("/problemes")
public class ProblemeController {
	
	@Autowired
	private ProblemeDAO problemeDAO;
	
	//@Autowired
	//private ServiceProbleme sp;
	
	@Autowired
	SessionId session;

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
	public String ajouterProbleme(Map<String, Object> model) {
		return "/ajouterProbleme";
	}
	
	@GetMapping("/soumettreProbleme")
	public String soumettreProbleme(Map<String, Object> model) {
		String objet = (String) model.get("objet");
		String contenu = (String) model.get("contenu");
		//Personne personne = PersonneDAO.getPersonneById(session.getCurrentUserId());
		//Probleme unProbleme = new Probleme(null, objet, contenu, , ,long dateHeureProbleme);
		//problemeDAO.addProbleme(Probleme unProbleme);
		return "/soumettreProbleme";
	}
}
