package com.projetFinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.Notification;

@Repository
@Transactional
public class NotificationDAO {
	@PersistenceContext
	EntityManager em;

	public List<Notification> getAllNotifications() {
		TypedQuery<Notification> q = em.createQuery("select n from Notification n", Notification.class);
		List<Notification> list = q.getResultList();
		return list;
	}

	public void addNotification(Notification notification) {
		em.persist(notification);
	}
	
	public List<Notification> getNotificationsByIdEtu(Integer id) {
		TypedQuery<Notification> q = em.createQuery("select n from Notification n \r\n" + 
				"join fetch n.etudiants e where e.idEtudiant=:id", Notification.class);
		q.setParameter("id", id);
		List<Notification> list = q.getResultList();
		return list;
	}
		
	public void supprNotificationById(Integer id) {
//		TypedQuery<Notification> q = em.createQuery("select n from Notification n "
//		+ "join fetch n.etudiants e where e.idEtudiant=:id", Notification.class);
//		TypedQuery<Notification> q = em.createQuery("select n from Notification n "
//				+ "join fetch n.etudiants e where e.idEtudiant=:id", Notification.class);
//		q.setParameter("id", id);
//		List<Notification> list = q.getResultList();
//		for (Notification notification : list) {
//			em.remove(notification);
//		}
		Notification notification = em.find(Notification.class, id);
		em.remove(notification);
	}
}
