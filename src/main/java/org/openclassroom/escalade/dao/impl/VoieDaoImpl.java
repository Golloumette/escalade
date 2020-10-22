package org.openclassroom.escalade.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.openclassroom.escalade.dao.VoieDao;
import org.openclassroom.escalade.model.VoieBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VoieDaoImpl implements VoieDao{
	
	@Autowired
	EntityManagerFactory emf;
	
	@Override
	public List<VoieBo> liste(){
	return emf.createEntityManager().createQuery("from VoieBo").getResultList();
	
	}
	
	@Override
	public VoieBo insertion (VoieBo voieBo) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(voieBo);
		em.getTransaction().commit();
		return voieBo;
	}
	
	@Override
	public List<VoieBo> liste (Integer id){
		return emf.createEntityManager().createQuery("from VoieBo where secteurBo.id= :id").setParameter("id", id).getResultList();
				
	}
	
	@Override
	public void deleteById(Integer id) {
EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		VoieBo voieBo = em.find(VoieBo.class, id);
		em.remove(voieBo);
		em.getTransaction().commit();
	
		
	}
	
	@Override
	public VoieBo update(VoieBo voieBo) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(voieBo);
		em.getTransaction().commit();
		return voieBo;
	}
	@Override
	public VoieBo getById(Integer id) {
		EntityManager em = emf.createEntityManager();
		 VoieBo voieBo = em.find(VoieBo.class, id);
		return voieBo;
	}
}
