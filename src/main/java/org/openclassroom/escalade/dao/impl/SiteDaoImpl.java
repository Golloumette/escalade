package org.openclassroom.escalade.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.openclassroom.escalade.dao.SiteDao;
import org.openclassroom.escalade.model.SecteurBo;
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
	@Override
	public List<SiteBo> liste(String nom){//,String lieu) {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<SiteBo> cq = cb.createQuery(SiteBo.class);
		
		Root<SiteBo> siteBo = cq.from(SiteBo.class);
		Predicate nomPredicate = cb.like(siteBo.get("nom"),"%"+ nom + "%");
		//Predicate lieuPredicate = cb.like(siteBo.get("lieu"),"%"+lieu + "%");
		cq.where(nomPredicate);//,lieuPredicate);
		
		TypedQuery<SiteBo> query = em.createQuery(cq);
		return query.getResultList();
	}
	
	@Override
	public List<SiteBo> listeCotation (String lieu, Integer nbSecteur, Byte cotation){
		String sqlString = "SELECT site.id, site.lieu, count(*) as nb FROM secteur join site on site.id = secteur.site_id join voie on secteur.id = voie.secteur_id WHERE site.lieu LIKE=:%lieu% and voie.cotation=:cotation GROUP BY site_id HAVING nb > 0 and nb < 1000";
			//	+ "site,secteur,voie WHERE secteur.site_id = site.id and voie.secteur_id = secteur.id and voie.cotation=:cotation and site.lieu=:lieu " ;
		return emf.createEntityManager().createNativeQuery(sqlString).setParameter("cotation", cotation).setParameter("lieu", lieu).setParameter("nbSecteur", nbSecteur).getResultList();
		
		
		
		
	}

}
