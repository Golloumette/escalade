package org.openclassroom.escalade.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.openclassroom.escalade.dao.SiteDao;
import org.openclassroom.escalade.model.SiteBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SiteDaoImpl implements SiteDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	@Override
	public List<SiteBo> liste() {
			return emf.createEntityManager().createQuery("from SiteBo").getResultList();
	}
	@Override
	public List<SiteBo> liste(Integer id) {
		return emf.createEntityManager().createQuery("from SiteBo where id= :id" ).setParameter("id", id).getResultList();
}


	@Override
	public SiteBo insertion(SiteBo siteBo) {
		EntityManager em = emf.createEntityManager();
		
		 em.getTransaction().begin();
		 em.persist(siteBo);
		 em.getTransaction().commit();
		 return siteBo;
	}


	@Override
	public SiteBo update(SiteBo siteBo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(siteBo);
		em.getTransaction().commit();
		return siteBo;
	}


	@Override
	 public SiteBo getById(Integer id) {
	 EntityManager em = emf.createEntityManager();
	 SiteBo siteBo = em.find(SiteBo.class, id);
	 
	
	return siteBo;
	}


	@Override
	public void deleteById(Integer id) {
	EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		SiteBo siteBo = em.find(SiteBo.class, id);
		 em.remove(siteBo);
		em.getTransaction().commit();
		
	}
	
	

}
