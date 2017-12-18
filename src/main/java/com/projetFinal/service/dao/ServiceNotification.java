package com.projetFinal.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projetFinal.model.dao.DirEtablissementDAO;
import com.projetFinal.model.dao.DirEtudesDAO;
import com.projetFinal.model.dao.EtudiantDAO;
import com.projetFinal.model.dao.NotificationDAO;
import com.projetFinal.model.dao.RecevoirDAO;
import com.projetFinal.model.dao.VoterDAO;
import com.projetFinal.model.metier.DirEtablissement;
import com.projetFinal.model.metier.DirEtudes;
import com.projetFinal.model.metier.Etudiant;
import com.projetFinal.model.metier.Notification;
import com.projetFinal.model.metier.Recevoir;

@Repository
@Transactional
public class ServiceNotification {
	@PersistenceContext
	EntityManager em;

	@Autowired
	private NotificationDAO notificationDAO;
	
	@Autowired
	private RecevoirDAO recevoirDAO;
	
	@Autowired
	private DirEtablissementDAO dirEtablissementDAO;
	
	@Autowired
	private DirEtudesDAO dirEtudesDAO;
	
	@Autowired
	private EtudiantDAO etudiantDAO;

	public List<Notification> getAllNotifications() {
		List<Notification> listeNotifications = notificationDAO.getAllNotifications();
		return listeNotifications;
	}
	
	public List<Notification> getNotificationsByIdEtu(Integer id) {
		List<Notification> listeNotifications = notificationDAO.getNotificationsByIdEtu(id);
		return listeNotifications;
	}
	
	public DirEtablissement getDirEtaById(Integer id) {
		DirEtablissement dirEtablissement = dirEtablissementDAO.getDirEtablissementById(id);
		return dirEtablissement;
	}
	
	public DirEtudes getDirEtudesById(Integer id) {
		DirEtudes dirEtudes = dirEtudesDAO.getDirEtudesById(id);
		return dirEtudes;
	}
	
	public List<Etudiant> getAllEtudiant() {
		List<Etudiant> listeEtudiants = etudiantDAO.getAllEtudiant();
		return listeEtudiants;
	}
	
	public List<Etudiant> getEtudiantByFiliere(int idFiliere) {
		List<Etudiant> listeEtudiants = etudiantDAO.getEtudiantByFiliere(idFiliere);
		return listeEtudiants;
	}
	
	public void addNotification(Notification notification) {
		notificationDAO.addNotification(notification);
	}
	
	public void addRecevoir(Recevoir unRecevoir) {
		recevoirDAO.addRecevoir(unRecevoir);
	}
	
	public void supprNotification(Integer id) {
		notificationDAO.supprNotificationById(id);
	}
	
	public List<Recevoir> getRecepteursByIdNotif(Integer idNotif) {
		List<Recevoir> listeRecepteurs = recevoirDAO.getRecepteursByIdNotif(idNotif);
		return listeRecepteurs;
	}
	
	public void supprRecepteurs(List<Recevoir> listeRecepteurs) {
		recevoirDAO.supprRecepteurs(listeRecepteurs);
	}
}
