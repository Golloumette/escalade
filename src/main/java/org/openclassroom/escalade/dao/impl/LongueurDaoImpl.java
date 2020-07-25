package org.openclassroom.escalade.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.openclassroom.escalade.dao.LongueurDao;
import org.openclassroom.escalade.model.LongueurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LongueurDaoImpl implements LongueurDao {
	
	@Autowired
	EntityManagerFactory emf;

	@Override
	public List<LongueurBo> liste() {
		
		return emf.createEntityManager().createQuery("from LongueurBo").getResultList();
	}

	@Override
	public LongueurBo insertion(LongueurBo longueurBo) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(longueurBo);
		em.getTransaction().commit();
		return longueurBo;
	}

	@Override
	public LongueurBo update(LongueurBo longueurBo) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(longueurBo);
		em.getTransaction().commit();
		return longueurBo;
		
	}

	@Override
	public LongueurBo getById(Integer id) {
		EntityManager em = emf.createEntityManager();
		LongueurBo longueurBo = em.find(LongueurBo.class,id);
		
		return longueurBo;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		LongueurBo longueurBo = em.find(LongueurBo.class,id);
		em.remove(longueurBo);
		em.getTransaction().commit();
	
		
	}
	

}
