package com.projetFinal.service.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projetFinal.model.dao.PersonneDAO;
import com.projetFinal.model.dao.ProblemeDAO;
import com.projetFinal.model.dao.StatusDAO;

@Repository
@Transactional
public class ServiceProbleme {
	
	@Autowired
	private ProblemeDAO problemeDAO;
	
	@Autowired
	private PersonneDAO personneDAO;
	
	@Autowired
	private StatusDAO statusDAO;
	
//	@Autowired
//	private VoteDAO voteDAO;
	
	public void maMethode() {
		int id = 0;
		problemeDAO.getProblemeById(id);
		personneDAO.getAllPersonne();
	}

}
