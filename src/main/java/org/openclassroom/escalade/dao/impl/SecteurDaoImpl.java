package org.openclassroom.escalade.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.openclassroom.escalade.dao.SecteurDao;
import org.openclassroom.escalade.model.SecteurBo;
import org.openclassroom.escalade.model.SiteBo;
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
	public SecteurBo deleteById(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.remove(SecteurBo.class);
		em.getTransaction().commit();
		return null;
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
	

}
