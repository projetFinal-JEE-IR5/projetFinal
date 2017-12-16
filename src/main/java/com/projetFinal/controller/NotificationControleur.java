package com.projetFinal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projetFinal.model.metier.DirEtablissement;
import com.projetFinal.model.metier.DirEtudes;
import com.projetFinal.model.metier.Etudiant;
import com.projetFinal.model.metier.Notification;
import com.projetFinal.model.metier.Probleme;
import com.projetFinal.model.metier.Status;
import com.projetFinal.service.dao.ServiceNotification;

@Controller
@RequestMapping("/notification")
public class NotificationControleur {
	
	@Autowired
	private ServiceNotification serviceNotification;
	
	@Autowired
	SessionId session;

	@GetMapping("/afficherNotificationsEtu")
	public String afficherNotificationsEtu(Map<String, Object> model) {
		List<Notification> listeNotification = serviceNotification.getNotificationsByIdEtu(session.getCurrentUserId());
		model.put("listeNotification", listeNotification);
		return "/afficherNotificationsEtu";
	}
	
	@GetMapping("/afficherNotificationsDirEtu")
	public String afficherNotificationsDirEtu(Map<String, Object> model) {
		List<Notification> listeNotification = serviceNotification.getAllNotifications();
		model.put("listeNotification", listeNotification);
		return "/afficherNotificationsDirEtu";
	}
	
	@GetMapping("/afficherNotificationsDirEta")
	public String afficherNotificationsDirEta(Map<String, Object> model) {
		List<Notification> listeNotification = serviceNotification.getAllNotifications();
		model.put("listeNotification", listeNotification);
		return "/afficherNotificationsDirEta";
	}
	
	@GetMapping("/ajouterNotificationDirEta")
	public String ajouterNotificationDirEta() {
		return "/ajouterNotificationDirEta";
	}
	
	@PostMapping("/ajouterNotificationDirEta")
	public String envoyerNotificationAllEtu(@RequestParam Map<String, String> formValues, Map<String, Object> model) {
		String contenu = formValues.get("contenu");
		DirEtablissement dirEtablissement = serviceNotification.getDirEtaById(session.getCurrentUserId());
		String format = "ddMMyyHmmss"; 
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date date = new java.util.Date(); 
		long dateHeureNotif = Long.valueOf(formater.format(date));
		//long dateHeureProbleme = 1509380153;
		Notification notification = new Notification(null, dateHeureNotif, contenu, null, dirEtablissement);
		serviceNotification.addNotification(notification);
		//on affiche la nouvelle liste de notif
		List<Notification> listeNotification = serviceNotification.getAllNotifications();
		model.put("listeNotification", listeNotification);
		return "/afficherNotificationsDirEta";
	}	
	
	@GetMapping("/ajouterNotificationDirEtu")
	public String ajouterNotificationDirEtu() {
		return "/ajouterNotificationDirEtu";
	}
	
	@PostMapping("/ajouterNotificationDirEtu")
	public String envoyerNotificationFiliere(@RequestParam Map<String, String> formValues, Map<String, Object> model) {
		String contenu = formValues.get("contenu");
		DirEtablissement dirEtablissement = serviceNotification.getDirEtaById(session.getCurrentUserId());
		String format = "ddMMyyHmmss"; 
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date date = new java.util.Date(); 
		long dateHeureNotif = Long.valueOf(formater.format(date));
		//long dateHeureProbleme = 1509380153;
		Notification notification = new Notification(null, dateHeureNotif, contenu, null, dirEtablissement);
		serviceNotification.addNotification(notification);
		//on affiche la nouvelle liste de notif
		List<Notification> listeNotification = serviceNotification.getAllNotifications();
		model.put("listeNotification", listeNotification);
		return "/afficherNotificationsDirEtu";
	}	
}
