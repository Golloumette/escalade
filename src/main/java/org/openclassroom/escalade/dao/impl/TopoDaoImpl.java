package org.openclassroom.escalade.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.openclassroom.escalade.dao.TopoDao;
import org.openclassroom.escalade.model.TopoBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TopoDaoImpl implements TopoDao {
 
	@Autowired
	EntityManagerFactory emf;

	@Override
	public List<TopoBo> liste() {
				return emf.createEntityManager().createQuery("from TopoBo").getResultList();
	}

	@Override
	public TopoBo insertion(TopoBo topoBo) {
		EntityManager em = emf.createEntityManager();
	
		 em.getTransaction().begin();
		 em.persist(topoBo);
		 em.getTransaction().commit();
		return topoBo;
	}

	@Override
	public TopoBo update(TopoBo topoBo) {
		EntityManager em = emf.createEntityManager();
	
		em.getTransaction().begin();
		em.merge(topoBo);
		em.getTransaction().commit();
		return topoBo;
	
	}
	
	
}
