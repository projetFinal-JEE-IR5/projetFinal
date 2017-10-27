package com.projetFinal.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		model.put("message", "test");
		return "welcome";
	}
	
	@PostMapping("/welcome")
	public void test(@RequestParam Map<String, String> formValues) {
		System.out.println(formValues.get("login")+formValues.get("password"));
	}

}