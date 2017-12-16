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
	public String infoPersonne(Map<String, Object> model) {
		Integer currentUserId = session.getCurrentUserId();
		String currentTypePersonne = session.getCurrentTypePersonne();
 
		if (currentTypePersonne == "dirEtablissement") {
			DirEtablissement dirEtablissement = (DirEtablissement) servicePersonnes.getPersonne(currentUserId, currentTypePersonne);
			model.put("role", "Directeur Etablissement");
			model.put("typePersonne", dirEtablissement);
			
		} else if (currentTypePersonne == "dirEtudes")	{
			DirEtudes dirEtudes = (DirEtudes) servicePersonnes.getPersonne(currentUserId, currentTypePersonne);
			model.put("role", "Directeur Etudes");
			model.put("typePersonne", dirEtudes);
			
		} else if (currentTypePersonne == "etudiant") {
			Etudiant etudiant = (Etudiant) servicePersonnes.getPersonne(currentUserId, currentTypePersonne);
			model.put("role", "Etudiant");
			model.put("typePersonne", etudiant);
		}

		return "/informations";
	}
}
