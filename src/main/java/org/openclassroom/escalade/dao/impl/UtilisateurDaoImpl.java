package org.openclassroom.escalade.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.openclassroom.escalade.dao.UtilisateurDao;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UtilisateurDaoImpl implements UtilisateurDao {

	@Autowired
	EntityManagerFactory emf;

	@Override
	public List<UtilisateurBo> liste() {

		return emf.createEntityManager().createQuery("from UtilisateurBo").getResultList();
	}

	@Override
	public UtilisateurBo insertion(UtilisateurBo utilisateurBo) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(utilisateurBo);
		em.getTransaction().commit();
		return utilisateurBo;

	}

	@Override
	public UtilisateurBo update(UtilisateurBo utilisateurBo) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.merge(utilisateurBo);
		em.getTransaction().commit();
		return utilisateurBo;
	}

	@Override
	public UtilisateurBo getById(Integer id) {
		EntityManager em = emf.createEntityManager();
		UtilisateurBo utilisateurBo = em.find(UtilisateurBo.class,id);
		return utilisateurBo;
	}

	@Override
	public void  deleteById(Integer id) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		UtilisateurBo utilisateurBo = em.find(UtilisateurBo.class,id);
		em.remove(utilisateurBo);
		em.getTransaction().commit();
	
	}

	@Override
	public UtilisateurBo findByPseudo(String pseudo) {
		return (UtilisateurBo) emf.createEntityManager().createQuery("from UtilisateurBo where pseudo= :pseudo ").setParameter("pseudo", pseudo).getSingleResult();
	
	}

}
