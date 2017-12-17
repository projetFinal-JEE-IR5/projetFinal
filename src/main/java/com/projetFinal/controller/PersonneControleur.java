package com.projetFinal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetFinal.model.metier.DirEtablissement;
import com.projetFinal.model.metier.DirEtudes;
import com.projetFinal.model.metier.Etudiant;
import com.projetFinal.service.dao.ServicePersonnes;

@Controller
@RequestMapping("/personnes")
public class PersonneControleur {
	String template="/fragments/template";

	@Autowired
	private ServicePersonnes servicePersonnes;

	@Autowired
	Session session;

	@GetMapping("/informations")
	public String infoPersonne(Map<String, Object> model) {
		Integer currentUserId = session.getCurrentUserId();
		String currentTypePersonne = session.getCurrentTypePersonne();
		String action = "informations"; 
 
		if (currentTypePersonne == "dirEtablissement") {
			DirEtablissement dirEtablissement = (DirEtablissement) servicePersonnes.getPersonne(currentUserId, currentTypePersonne);
			model.put("role", "Directeur Etablissement");
			model.put("personne", dirEtablissement);
			
		} else if (currentTypePersonne == "dirEtudes")	{
			DirEtudes dirEtudes = (DirEtudes) servicePersonnes.getPersonne(currentUserId, currentTypePersonne);
			model.put("role", "Directeur Etudes");
			model.put("personne", dirEtudes);
			
		} else if (currentTypePersonne == "etudiant") {
			Etudiant etudiant = (Etudiant) servicePersonnes.getPersonne(currentUserId, currentTypePersonne);
			model.put("role", "Etudiant");
			model.put("personne", etudiant);
		}
		model.put("action", action);
		model.put("typePersonne", currentTypePersonne);
		return template;
	}
}
