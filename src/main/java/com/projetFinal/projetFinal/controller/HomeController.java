package com.projetFinal.projetFinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping
	public String lancement() {
		return "test";		
	}
	
}
