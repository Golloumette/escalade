package org.openclassroom.escalade.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="topo")
public class TopoBo {
	private Integer Id;
	private String nom;
	private String description;
	private String lieu;
	private Date dt_parution;
	private Byte disponible;
	private UtilisateurBo utilisateurBo;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}	
	public Byte getDisponible() {
		return disponible;
	}
	public void setDisponible(Byte disponible) {
		this.disponible = disponible;
	}
	public Date getDt_parution() {
		return dt_parution;
	}
	public void setDt_parution(Date dt_parution) {
		this.dt_parution = dt_parution;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="utilisateur_id")
	public UtilisateurBo getUtilisateurBo() {
		return utilisateurBo;
	}
	public void setUtilisateurBo(UtilisateurBo utilisateurBo) {
		this.utilisateurBo = utilisateurBo;
	}
	@OneToMany(mappedBy="topoBo")
	public List<ReservationBo> getReservationBos() {
		return reservationBos;
	}
	public void setReservationBos(List<ReservationBo> reservationBos) {
		this.reservationBos = reservationBos;
	}
	
	
	
	

}
