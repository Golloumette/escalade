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
	private Boolean officiel;
	
	private List<SecteurBo> secteurBos ;
	private List<CommentaireBo> commentaireBos;
	
	
	
	
	
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
	public Boolean getOfficiel() {
		return officiel;
	}
	public void setOfficiel(Boolean officiel) {
		this.officiel = officiel;	
	}
	@OneToMany(mappedBy="siteBo")
	public List<SecteurBo> getSecteurBos() {
		return secteurBos;
	}
	public void setSecteurBos(List<SecteurBo> secteurBos) {
		this.secteurBos = secteurBos;
	}
	@OneToMany(mappedBy="siteBo")
	public List<CommentaireBo> getCommentaireBos() {
		return commentaireBos;
	}
	public void setCommentaireBos(List<CommentaireBo> commentaireBos) {
		this.commentaireBos = commentaireBos;
	}

}
