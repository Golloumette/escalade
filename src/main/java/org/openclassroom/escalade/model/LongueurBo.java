package org.openclassroom.escalade.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="longueur")
public class LongueurBo {
	private Integer id;
	private String nom;
	private String cotation;
	private String subdivision;
	private String spit;
	private VoieBo voieBo;
	
	
	
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
	public String getCotation() {
		return cotation;
	}
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	public String getSubdivision() {
		return subdivision;
	}
	public void setSubdivision(String subdivision) {
		this.subdivision = subdivision;
	}
	public String getSpit() {
		return spit;
	}
	public void setSpit(String spit) {
		this.spit = spit;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="voie_id")
	public VoieBo getVoieBo() {
		return voieBo;
	}
	public void setVoieBo(VoieBo voieBo) {
		this.voieBo = voieBo;
	}
	
	
	
	

}
