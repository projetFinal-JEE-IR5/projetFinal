package com.projetFinal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projetFinal.model.metier.DirEtablissement;
import com.projetFinal.model.metier.DirEtudes;
import com.projetFinal.model.metier.Etudiant;
import com.projetFinal.service.dao.ServicePersonnes;

@Controller
public class HomeController {
		
	@Autowired
	private ServicePersonnes servicePersonnes;
	
	@Autowired
	private SessionId session;

	@GetMapping("/")
	public String welcome(Map<String, String> model) {
		model.put("message", "Se connecter");
		return "welcome";
	}
	
	@PostMapping("/")
	public String connexion(@RequestParam Map<String, String> formValues, Map<String, String> model) {
		model.put("message", "Se connecter");
		String menu="/welcome";
		String login = formValues.get("login");
		String password = formValues.get("password");

		String typePersonne = servicePersonnes.trouverTypePersonne(login);
		session.setCurrentTypePersonne(typePersonne);
		
		if (typePersonne=="dirEtablissement") {
			DirEtablissement dirEtablissement = (DirEtablissement) servicePersonnes.getPersonnebyLoginPassword(login, password, typePersonne);
			session.setCurrentUserId(dirEtablissement.getIdDirEtablissement());
			menu = "/menuDirecteurEtab";
			
		}else if (typePersonne=="dirEtudes") {
			DirEtudes dirEtudes = (DirEtudes) servicePersonnes.getPersonnebyLoginPassword(login, password, typePersonne);
			session.setCurrentUserId(dirEtudes.getIdDirEtudes());
			menu = "/menuDirecteurEtud";
			
		}else if (typePersonne=="etudiant") {
			Etudiant etudiant = (Etudiant) servicePersonnes.getPersonnebyLoginPassword(login, password, typePersonne);
			session.setCurrentUserId(etudiant.getIdEtudiant());
			menu = "/menuEtudiant";
		}
		
		model.put("login", login);
		model.put("password", password);
		return menu;
	}
//http://www.thymeleaf.org/doc/articles/layouts.html
}