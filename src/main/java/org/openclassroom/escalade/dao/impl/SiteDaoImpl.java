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
		// TODO Auto-generated method stub
		return emf.createEntityManager().createQuery("from SiteBo").getResultList();
	}


	@Override
	public SiteBo insertion(SiteBo siteBo) {
		EntityManager em = emf.createEntityManager();
		// TODO Auto-generated method stub
		 em.getTransaction().begin();
		 em.persist(siteBo);
		 em.getTransaction().commit();
		 return siteBo;
	}
	
	

}
