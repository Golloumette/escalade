package org.openclassroom.escalade.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.openclassroom.escalade.dao.SecteurDao;
import org.openclassroom.escalade.model.SecteurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SecteurDaoImpl implements SecteurDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	
	//liste des secteurs
	@Override
	public List<SecteurBo> liste(){
		return emf.createEntityManager().createQuery("from SecteurBo").getResultList();
	}
	
	// Inserer un secteur
	@Override
	public SecteurBo insertion (SecteurBo secteurBo) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(secteurBo);
		em.getTransaction().commit();
		return secteurBo;
	}
	
	//Liste des secteurs a partir de l integer
	@Override
	public List<SecteurBo> liste(Integer id) {
		return emf.createEntityManager().createQuery("from SecteurBo where siteBo.id= :id" ).setParameter("id", id).getResultList();
}
	@Override
	public void deleteById(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		SecteurBo secteurBo = em.find(SecteurBo.class, id);
		em.remove(secteurBo);
		em.getTransaction().commit();
	
	}

	@Override
	public SecteurBo update(SecteurBo secteurBo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(secteurBo);
		em.getTransaction().commit();
		return secteurBo;
	}

	@Override
	public SecteurBo getById(Integer id) {
		EntityManager em = emf.createEntityManager();
		 SecteurBo secteurBo = em.find(SecteurBo.class, id);
		return secteurBo;
	}
	@Override
	public List<SecteurBo> liste1(Integer Site_id){
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<SecteurBo> cq = cb.createQuery(SecteurBo.class);
		
		Root<SecteurBo> secteurBo = cq.from(SecteurBo.class);
		Predicate nbrPredeciate = cb.like(secteurBo.get("site_id"),Site_id);
		cq.where(nbrPredeciate);
		
		TypedQuery<SecteurBo> query = em.createQuery(cq);
		return query.getResultList();
		
		
	}
	}
	

}
