package org.openclassroom.escalade.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.openclassroom.escalade.dao.ReservationDao;
import org.openclassroom.escalade.model.ReservationBo;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDaoImpl implements ReservationDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	@Override
	public List<ReservationBo> liste(){
		return emf.createEntityManager().createQuery("from ReservationBo").getResultList();
	}
	
	@Override 
	public ReservationBo insertion (ReservationBo reservationBo) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(reservationBo);
		em.getTransaction().commit();
		return reservationBo;
	}
	
	@Override
	public ReservationBo update (ReservationBo reservationBo) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(reservationBo);
		em.getTransaction().commit();
		return reservationBo;

}

	@Override
	public ReservationBo getById(Integer id) {
	EntityManager em = emf.createEntityManager();
	ReservationBo reservationBo = em.find(ReservationBo.class, id);
		
		return reservationBo;
	}   

	@Override
	public List<ReservationBo> findByTopoAndValid(Integer topo_id,Byte valider) {
		return  emf.createEntityManager().createQuery("from ReservationBo where topo_id= :topo_id and valider= :valider").setParameter("topo_id", topo_id).setParameter("valider",valider).getResultList();
		
	}

	@Override
	public ReservationBo findByValider(Byte valider) {
		
		return (ReservationBo) emf.createEntityManager().createQuery("from ReservationBo where valider= :valider").setParameter("valider", valider).getSingleResult()	;	
		}

	@Override
	public List<ReservationBo> liste(UtilisateurBo utilisateurBo) {
		return emf.createEntityManager().createQuery("from ReservationBo where utilisateurBo= :user").setParameter("user",utilisateurBo).getResultList();
	}

	
}
