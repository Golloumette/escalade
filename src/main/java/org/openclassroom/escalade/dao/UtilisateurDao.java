package org.openclassroom.escalade.dao;

import java.util.ArrayList;
import java.util.List;

import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class UtilisateurDao {
	HibernateTemplate template;  
	 
	//on doit ajouter une méthode set pour le conteneur Spring puise connaitre l’objet lors de la création d’objet et l’injection de dépandance.  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	//methode pour ajouter Personne  
	public void ajouterUtilisateur(UtilisateurBo e){  
	    template.save(e);  
	}  
	// methode pour  modifier Personne  
	public void modifierUtilisateur(UtilisateurBo e){  
	    template.update(e);  
	}  
	// methode pour Supprimer Personne  
	public void supprimerUtilisateur(UtilisateurBo e){  
	    template.delete(e);  
	}  
	// methode pour selectionner une personne en utilisant l’id 
	public UtilisateurBo getById(Integer id){  
	    UtilisateurBo e=(UtilisateurBo)template.get(UtilisateurBo.class,id);  
	    return e;  
	}  
	//methode pour afficher toutes les personnes
	public List<UtilisateurBo> getUtilisateurBo(){  
	    List<UtilisateurBo> list=new ArrayList<UtilisateurBo>();  
	    list=template.loadAll(UtilisateurBo.class);  
	    return list;  
	}  
	}  


