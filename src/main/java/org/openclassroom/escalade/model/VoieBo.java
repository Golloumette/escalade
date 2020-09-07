package org.openclassroom.escalade.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="voie")
public class VoieBo {
	private Integer id;
	private String nom;
	private Integer cotation;
	private String subdivision;
	private Boolean equipe;
	private SecteurBo secteurBo;
	private List<LongueurBo> longueurBos;
	
	
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
	public Integer getCotation() {
		return cotation;
	}
	public void setCotation(Integer cotation) {
		this.cotation = cotation;
	}
	public String getSubdivision() {
		return subdivision;
	}
	public void setSubdivision(String subdivision) {
		this.subdivision = subdivision;
	}
	public Boolean getEquipe() {
		return equipe;
	}
	public void setEquipe(Boolean equipe) {
		this.equipe = equipe;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="secteur_id")
	public SecteurBo getSecteurBo() {
		return secteurBo;
	}
	public void setSecteurBo(SecteurBo secteurBo) {
		this.secteurBo = secteurBo;
	}
	@OneToMany(mappedBy = "voieBo")
	public List<LongueurBo> getLongueurBos() {
		return longueurBos;
	}
	public void setLongueurBos(List<LongueurBo> longueurBos) {
		this.longueurBos = longueurBos;
	}
	
	
	

}
