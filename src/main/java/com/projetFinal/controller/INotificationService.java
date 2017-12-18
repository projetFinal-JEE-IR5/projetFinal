package com.projetFinal.controller;

import java.util.Set;

import com.projetFinal.model.metier.DirEtablissement;
import com.projetFinal.model.metier.DirEtudes;
import com.projetFinal.model.metier.Etudiant;
import com.projetFinal.model.metier.Notification;

public interface INotificationService {

	Notification getNotificationDetail(Integer id, String contenu, long dateHeureNotif,
			DirEtablissement dir_etablissement, DirEtudes dir_etudes, Set<Etudiant> etudiants);

}
