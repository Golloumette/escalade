package org.openclassroom.escalade.dao.impl;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.openclassroom.escalade.dao.SiteDao;
import org.openclassroom.escalade.model.SecteurBo;
import org.openclassroom.escalade.model.SiteBo;
import org.openclassroom.escalade.model.VoieBo;
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
		cq.where(nomPredicate);
		
		TypedQuery<SiteBo> query = em.createQuery(cq);
		return query.getResultList();
	}
	
	@Override
	public List<Object[]> listeCotation (String lieu, Integer nbSecteur, Byte cotation){
		System.out.println("nombre de secteur= "+nbSecteur+"cotation= "+cotation );
		
		String sqlString = "SELECT site_id, site.lieu, count(*) as nb FROM secteur join site on site.id = secteur.site_id WHERE 0 = 0 ";
		String sql1= "SELECT site_id, site.lieu, count(*) as nb FROM secteur join site on site.id = secteur.site_id "  ;
		String sql2=" join voie on secteur.id = voie.secteur_id";
		String sql3=" WHERE 0 = 0 ";
		String sql4=" GROUP BY site_id HAVING nb > 0 and nb < 1000";
		String sql5=" and site.lieu LIKE :lieu";
		
		if (lieu!=null && !lieu.equals("")) {
			sqlString +=" and site.lieu LIKE :lieu";
		}
		if (cotation!= null) {
			System.out.println("entre boucle cotation");
			sqlString =sql1+sql2+sql3+" and voie.cotation=:cotation";
			System.out.println(sqlString);        
		}
		if (cotation == null) {
			sqlString+=" and voie.cotation=:cotation";
		}
		
	
		//sqlString+=" GROUP BY site_id HAVING nb > 0 and nb < 1000";
		
		if (nbSecteur==1) {
			System.out.println("boucle nbsecteur = 1");
			sqlString+=" GROUP BY site_id HAVING nb > 0 and nb < 5";//if nb secteur 
			System.out.println(sqlString);
		}
		if (nbSecteur==0) {
			System.out.println("boucle nbsecteur = 0");
			sqlString+=" GROUP BY site_id HAVING nb > 0 and nb < 1000"; 
			System.out.println(sqlString);
		}
		if (nbSecteur==2) {
			System.out.println("boucle nbsecteur = 2");
			sqlString+=" GROUP BY site_id HAVING nb > 4 and nb < 11"; 
		}
		if (nbSecteur==3) {
			System.out.println("boucle nbsecteur = 3");
			sqlString+= " GROUP BY site_id HAVING nb > 10 ";
			System.out.println(sqlString);
		}
		 
		Query query = emf.createEntityManager().createNativeQuery(sqlString);
		if (lieu!=null && !lieu.equals("")) {		
		query.setParameter("lieu", "%"+lieu+"%");
		}
		if (cotation!=null) {
		query.setParameter("cotation", cotation);
		}
			
		return query.getResultList();
	
			}
	

}
