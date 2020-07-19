package org.openclassroom.escalade.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="secteur")
public class SecteurBo {
	private Integer id;
	private String nom;
	private String descriptif;
	private String acces;
	private SiteBo siteBo;

	
	
	
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
	public String getDescriptif() {
		return descriptif;
	}
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	public String getAcces() {
		return acces;
	}
	public void setAcces(String acces) {
		this.acces = acces;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="site_id")
	public SiteBo getSiteBo() {
		return siteBo;
	}
		public void setSiteBo(SiteBo siteBo) {
		this.siteBo = siteBo;
	}
	
}
