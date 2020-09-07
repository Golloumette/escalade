package org.openclassroom.escalade.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="site")
public class SiteBo {
	private Integer id;
	private String nom;
	private String lieu;
	private List<SecteurBo> secteurBos ;
	
	
	
	@OneToMany(mappedBy="siteBo")
	public List<SecteurBo> getSecteurBos() {
		return secteurBos;
	}
	public void setSecteurBos(List<SecteurBo> secteurBos) {
		this.secteurBos = secteurBos;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	

}
