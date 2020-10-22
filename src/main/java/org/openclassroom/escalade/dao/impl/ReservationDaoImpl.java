package org.openclassroom.escalade.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.openclassroom.escalade.dao.ReservationDao;
import org.openclassroom.escalade.model.ReservationBo;
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
	public ReservationBo validation (ReservationBo reservationBo) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(reservationBo);
		em.getTransaction().commit();
		return reservationBo;

}
}
