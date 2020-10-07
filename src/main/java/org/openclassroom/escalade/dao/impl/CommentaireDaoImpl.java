package org.openclassroom.escalade.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.openclassroom.escalade.dao.CommentaireDao;
import org.openclassroom.escalade.model.CommentaireBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CommentaireDaoImpl implements CommentaireDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	@Override
	public List<CommentaireBo> commentaire(){
		return emf.createEntityManager().createQuery("from CommentaireBo").getResultList();
	}
	public List<CommentaireBo> liste(Integer id){
		return emf.createEntityManager().createQuery("from CommentaireBo where siteBo.id= :id").setParameter("id", id).getResultList();
	}

	@Override
	public CommentaireBo insertion(CommentaireBo commentaireBo) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(commentaireBo);
		em.getTransaction().commit();
		return commentaireBo;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		CommentaireBo commentaireBo = em.find(CommentaireBo.class, id);
		em.remove(commentaireBo);
		em.getTransaction().commit();
		
	}

	@Override
	public CommentaireBo update(CommentaireBo commentaireBo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(commentaireBo);
		em.getTransaction().commit();
		return commentaireBo;
	}

	@Override
	public CommentaireBo getById(Integer id) {
		EntityManager em = emf.createEntityManager();
		CommentaireBo commentaireBo = em.find(CommentaireBo.class, id);
		return commentaireBo;
	}

}
