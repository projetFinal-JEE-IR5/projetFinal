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
public class HomeController{
	String template="/fragments/template";
	
	@Autowired
	private ServicePersonnes servicePersonnes;
	
	@Autowired
	private Session session;

	@GetMapping("/")
	public String connection(Map<String, String> model) {
		model.put("message", "Se connecter");
		return "connection";
	}
	
	@PostMapping("/")
	public String connexion(@RequestParam Map<String, String> formValues, Map<String, String> model) {
		model.put("message", "Se connecter");
		String action = "connection"; 
		String login = formValues.get("login");
		String password = formValues.get("password");

		String typePersonne = servicePersonnes.trouverTypePersonne(login);
		session.setCurrentTypePersonne(typePersonne);
		
		if (typePersonne=="dirEtablissement") {
			DirEtablissement dirEtablissement = (DirEtablissement) servicePersonnes.getPersonnebyLoginPassword(login, password, typePersonne);
			session.setCurrentUserId(dirEtablissement.getIdDirEtablissement());
			session.setCurrentLogin(dirEtablissement.getLogin());
			action = "welcome";
			
		}else if (typePersonne=="dirEtudes") {
			DirEtudes dirEtudes = (DirEtudes) servicePersonnes.getPersonnebyLoginPassword(login, password, typePersonne);
			session.setCurrentUserId(dirEtudes.getIdDirEtudes());
			session.setCurrentLogin(dirEtudes.getLogin());
			action = "welcome";
			
		}else if (typePersonne=="etudiant") {
			Etudiant etudiant = (Etudiant) servicePersonnes.getPersonnebyLoginPassword(login, password, typePersonne);
			session.setCurrentUserId(etudiant.getIdEtudiant());
			session.setCurrentLogin(etudiant.getLogin());
			action = "welcome"; 
			
		}
		
		model.put("action", action);
		model.put("typePersonne", typePersonne);
		model.put("login", login);
		return template; 
	}
//http://www.thymeleaf.org/doc/articles/layouts.html
}