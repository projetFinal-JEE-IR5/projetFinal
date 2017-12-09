package com.projetFinal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.projetFinal.model.dao.PersonneDAO;
import com.projetFinal.model.metier.Personne;

@Controller
@RequestMapping("/personnes")
public class PersonneControleur {
	
	@Autowired
	private PersonneDAO personneDAO;
	
	@Autowired
	SessionId session;

	@GetMapping("/informations")
	public String infoPersonne(Map<String, String> model) {
		Personne personne = personneDAO.getPersonneById(session.getCurrentUserId());
		model.put("prenom", personne.getPrenom());
		model.put("nom", personne.getNom());
		model.put("role", personne.getRole().getLibelle());
		return "/informations";
	}
}
