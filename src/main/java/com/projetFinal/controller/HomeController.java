package com.projetFinal.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

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
		if(login.equals("benjamin") && password.equals("sabaron")) {
			menu = "/menu1";
		}
		if(login.equals("benjamin") && password.equals("marty")) {
			menu = "/menu2";
		}
		if(login.equals("antoine") && password.equals("richard")) {
			menu = "/menu3";
		}
		model.put("login", login);
		model.put("password", password);
		return menu;
	}

}