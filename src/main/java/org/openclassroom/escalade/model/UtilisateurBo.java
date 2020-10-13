package org.openclassroom.escalade.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="utilisateur")
public class UtilisateurBo {	
	private Integer Id;
	private String nom;
	private String prenom;
	private String pseudo;
	private String mdp;
	private String adresse;
	private String postal;
	private String ville;
	private String mail;
	private String tel;
	private Byte role;
	private List<TopoBo> topoBos;
	private List<CommentaireBo> commentaireBos;
	private List<ReservationBo> reservationBos;
	
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	@Column (name="mdp"  )
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Byte getRole() {
		return role;
	}
	public void setRole(Byte role) {
		this.role = role;
	}
	@OneToMany(mappedBy="utilisateurBo")
	public List<TopoBo> getTopoBos() {
		return topoBos;
	}
	public void setTopoBos(List<TopoBo> topoBos) {
		this.topoBos = topoBos;
		
	}
	@OneToMany(mappedBy="utilisateurBo")
	public List<CommentaireBo> getCommentaireBos() {
		return commentaireBos;
	}
	public void setCommentaireBos(List<CommentaireBo> commentaireBos) {
		this.commentaireBos = commentaireBos;
	}
	@OneToMany(mappedBy="utilisateurBo")
	public List<ReservationBo> getReservationBos() {
		return reservationBos;
	}
	public void setReservationBos(List<ReservationBo> reservationBos) {
		this.reservationBos = reservationBos;
	}

}
