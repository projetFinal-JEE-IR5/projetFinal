package com.projetFinal.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projetFinal.model.dao.DirEtablissementDAO;
import com.projetFinal.model.dao.DirEtudesDAO;
import com.projetFinal.model.dao.NotificationDAO;
import com.projetFinal.model.metier.DirEtablissement;
import com.projetFinal.model.metier.DirEtudes;
import com.projetFinal.model.metier.Notification;

@Repository
@Transactional
public class ServiceNotification {
	@PersistenceContext
	EntityManager em;

	@Autowired
	private NotificationDAO notificationDAO;
	
	@Autowired
	private DirEtablissementDAO dirEtablissementDAO;
	
	@Autowired
	private DirEtudesDAO dirEtudesDAO;

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
	
	public void addNotificationForAll(Notification notification) {
		notificationDAO.addNotificationForAll(notification);
	}
	
	public void addNotificationForFiliere(Notification notification, Integer idFiliere) {
		notificationDAO.addNotificationForFiliere(notification, idFiliere);
	}
	
	public void supprNotification(Integer id) {
		notificationDAO.supprNotificationById(id);
	}
}
