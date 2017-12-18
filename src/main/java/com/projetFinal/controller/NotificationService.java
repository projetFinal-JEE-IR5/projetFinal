package com.projetFinal.controller;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.projetFinal.model.metier.DirEtablissement;
import com.projetFinal.model.metier.DirEtudes;
import com.projetFinal.model.metier.Etudiant;
import com.projetFinal.model.metier.Notification;

@Component
public class NotificationService implements INotificationService {

	@Override
	public Notification getNotificationDetail(Integer id, String contenu, long dateHeureNotif,
			DirEtablissement dir_etablissement, DirEtudes dir_etudes, Set<Etudiant> etudiants) {
		Notification n = new Notification();
		n.setIdNotification(id);
		n.setContenu(contenu);
		n.setDateHeureNotif(dateHeureNotif);
		n.setDir_etablissement(dir_etablissement);
		n.setDir_etudes(dir_etudes);
		n.setEtudiants(etudiants);
		return n;
	}
}
