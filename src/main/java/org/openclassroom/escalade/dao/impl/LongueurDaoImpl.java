package org.openclassroom.escalade.dao.impl;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

	@Override
	public List<LongueurBo> liste(Integer id) {
		return emf.createEntityManager().createQuery("from LongueurBo where voieBo.id= :id").setParameter("id", id).getResultList();
	}

	@Override
	public List<LongueurBo> liste(String cotation) {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<LongueurBo> cq = cb.createQuery(LongueurBo.class);
		
		Root<LongueurBo> longueurBo = cq.from(LongueurBo.class);
		Predicate cotationPredicate = cb.like(longueurBo.get("cotation"),cotation);
		cq.where(cotationPredicate);
		
		TypedQuery<LongueurBo> query = em.createQuery(cq);
		return query.getResultList();
	}
	

}
