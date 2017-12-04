package com.projetFinal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.projetFinal.model.dao.ProblemeDAO;
import com.projetFinal.model.metier.Probleme;
import com.projetFinal.service.dao.ServiceProbleme;

@Controller
@RequestMapping("/probleme")
public class ProblemeController {
	
	@Autowired
	private ProblemeDAO problemeDAO;
	
	@Autowired
	private ServiceProbleme sp;
	
	@Autowired
	SessionId session;

	@GetMapping("/afficherProblemes")
	public String afficherProblemes(Map<String, Object> model) {
		//sp.maMethode();
		
		List<Probleme> listProblemes = problemeDAO.getAllProbleme();
		model.put("listProblemes", listProblemes);
		return "/afficherProblemes";
	}
}
