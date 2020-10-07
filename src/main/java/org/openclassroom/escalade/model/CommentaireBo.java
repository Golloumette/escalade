package org.openclassroom.escalade.model;

import java.util.Date;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commentaire")
public class CommentaireBo {
	private Integer id;
	private String text;
	private Date dt_comment;
	
	private UtilisateurBo utilisateurBo;
	//private SiteBo siteBo;
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDt_comment() {
		return dt_comment;
	}
	public void setDt_comment(Date dt_comment) {
		this.dt_comment = dt_comment;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="utilisateur_id")
	public UtilisateurBo getUtilisateurBo() {
		return utilisateurBo;
	}
	public void setUtilisateurBo(UtilisateurBo utilisateurBo) {
		this.utilisateurBo = utilisateurBo;
	}
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="site_id")
	public SiteBo getSiteBo() {
		return siteBo;
	}
	public void setSiteBo(SiteBo siteBo) {
		this.siteBo = siteBo;
	}*/
	
	
	

}
