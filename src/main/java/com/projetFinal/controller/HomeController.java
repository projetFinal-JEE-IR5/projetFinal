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
	public String test(@RequestParam Map<String, String> formValues) {
		System.out.println(formValues.get("login")+formValues.get("password"));
		return "/homeConnected";
	}

}