package com.projetFinal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notification")
public class NotificationControleur {
	
	@Autowired
	SessionId session;

	@GetMapping("/afficherNotificationsEtu")
	public String afficherNotificationsEtu(Map<String, String> model) {
		return "/afficherNotificationsEtu";
	}
	
	@GetMapping("/afficherNotificationsDirEtu")
	public String afficherNotificationsDirEtu(Map<String, String> model) {
		return "/afficherNotificationsDirEtu";
	}
	
	@GetMapping("/afficherNotificationsDirEta")
	public String afficherNotificationsDirEta(Map<String, String> model) {
		return "/afficherNotificationsDirEta";
	}
}
