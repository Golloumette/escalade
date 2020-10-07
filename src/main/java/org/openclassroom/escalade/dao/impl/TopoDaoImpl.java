package org.openclassroom.escalade.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.openclassroom.escalade.dao.TopoDao;
import org.openclassroom.escalade.model.SiteBo;
import org.openclassroom.escalade.model.TopoBo;
import org.openclassroom.escalade.model.UtilisateurBo;
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

	@Override
	public TopoBo getById(Integer id) {
		 EntityManager em = emf.createEntityManager();
		 TopoBo topoBo = em.find(TopoBo.class, id);
		 return topoBo;
	}

	@Override
	public void deleteById(Integer id) {
EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		TopoBo topoBo = em.find(TopoBo.class, id);
		 em.remove(topoBo);
		em.getTransaction().commit();
		
	}

	@Override
	public List<TopoBo> liste(Integer id) {
		return emf.createEntityManager().createQuery("from TopoBo where id= :id" ).setParameter("id", id).getResultList();
	}

	@Override
	public List<TopoBo> liste(UtilisateurBo utilisateurBo) {// objet : meme nom ou autre identique que dans le setparameter et dernier c'est le paramètre
		return emf.createEntityManager().createQuery("from TopoBo where utilisateurBo= :user" ).setParameter("user", utilisateurBo).getResultList();
	}
	
	
}
