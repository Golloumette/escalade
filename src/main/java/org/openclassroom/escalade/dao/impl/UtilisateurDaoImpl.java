package org.openclassroom.escalade.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.openclassroom.escalade.dao.UtilisateurDao;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UtilisateurDaoImpl implements UtilisateurDao {
	
	@Autowired
	EntityManagerFactory emf;

	@Override
	public List<UtilisateurBo> liste() {
		// TODO Auto-generated method stub
		
		return emf.createEntityManager().createQuery("UtilisateurBo").getResultList();
	}

	@Override
	public UtilisateurBo insertion(UtilisateurBo utilisateurBo) {
		EntityManager em = emf.createEntityManager();
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(utilisateurBo);
		em.getTransaction().commit();
		return utilisateurBo;
	
	}

}
