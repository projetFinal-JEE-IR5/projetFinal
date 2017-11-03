package com.projetFinal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projetFinal.model.dao.PersonneDAO;
import com.projetFinal.model.metier.Personne;

@Controller
public class HomeController {
	
	@Autowired
	private PersonneDAO personneDAO;
	
	public HomeController() {
		
	}

	@GetMapping("/")
	public String welcome(Map<String, String> model) {
		model.put("message", "Se connecter");
		return "welcome";
	}
	
	@PostMapping("/")
	public String connexion(@RequestParam Map<String, String> formValues, Map<String, String> model) {
		String menu="/";
		String login = formValues.get("login");
		String password = formValues.get("password");
		List<Personne> listePersonne = personneDAO.getAllPersonne();
		for (Personne personne : listePersonne) {
			if(personne.getRole().getIdRole()==1) {
				if(personne.getLogin().equals(login) && personne.getPassword().equals(password)) {
					menu = "/menu1";
				}
			}
			if(personne.getRole().getIdRole()==2) {
				if(personne.getLogin().equals(login) && personne.getPassword().equals(password)) {
					menu = "/menu2";
				}
			}
			if(personne.getRole().getIdRole()==2) {
				if(personne.getLogin().equals(login) && personne.getPassword().equals(password)) {
					menu = "/menu3";
				}
			}			
		}
		model.put("login", login);
		model.put("password", password);
		return menu;
	}

}