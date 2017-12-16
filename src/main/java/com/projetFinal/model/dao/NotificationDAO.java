package com.projetFinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projetFinal.model.metier.Notification;
import com.projetFinal.model.metier.Probleme;

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
				"inner join recevoir r on r.idNotification=n.idNotification where r.idEtudiant=:id", Notification.class);
		List<Notification> list = q.getResultList();
		return list;
	}
		
	public void deleteProblemesResolus() {
		TypedQuery<Probleme> q = em.createQuery("select p from Probleme p inner join Status s on p.idStatus=s.idStatus inner join Voter v on p.idProbleme=v.idProbleme where s.idStatus=2", Probleme.class);
		List<Probleme> list = q.getResultList();
		for (Probleme probleme : list) {
			em.remove(probleme);
		}
	}
}
