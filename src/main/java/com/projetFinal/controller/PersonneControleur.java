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

	@Autowired
	private ServicePersonnes servicePersonnes;

	@Autowired
	SessionId session;

	@GetMapping("/informations")
	public String infoPersonne(Map<String, String> model) {
		Integer currentUserId = session.getCurrentUserId();
		String currentTypePersonne = session.getCurrentTypePersonne();

		if (currentTypePersonne == "dirEtablissement") {
			DirEtablissement dirEtablissement = (DirEtablissement) servicePersonnes.getPersonne(currentUserId, currentTypePersonne);
			model.put("typePersonne", currentTypePersonne);
			model.put("login", dirEtablissement.getLogin());
			model.put("prenom", dirEtablissement.getPrenom());
			model.put("nom", dirEtablissement.getNom());
			
		} else if (currentTypePersonne == "dirEtudes")	{
			DirEtudes dirEtudes = (DirEtudes) servicePersonnes.getPersonne(currentUserId, currentTypePersonne);
			model.put("typePersonne", currentTypePersonne); 
			model.put("login", dirEtudes.getLogin());
			model.put("prenom", dirEtudes.getPrenom());
			model.put("nom", dirEtudes.getNom());
			model.put("filiere", dirEtudes.getFiliere().getNomFiliere());
			
		} else if (currentTypePersonne == "etudiant") {
			Etudiant etudiant = (Etudiant) servicePersonnes.getPersonne(currentUserId, currentTypePersonne);
			model.put("typePersonne", currentTypePersonne);
			model.put("login", etudiant.getLogin());
			model.put("prenom", etudiant.getPrenom());
			model.put("nom", etudiant.getNom());
			model.put("filiere", etudiant.getFiliere().getNomFiliere());
			model.put("nbprob", etudiant.getNbProbAutoriseJour().toString());
		}

		return "/informations";
	}
}
