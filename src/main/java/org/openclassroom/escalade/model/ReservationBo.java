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
@Table(name="reservation")
public class ReservationBo {
	private Integer id;
	
	private UtilisateurBo utilisateurBo;
	private TopoBo topoBo;
	private Date dt_reservation;
	private Byte valider;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="utilisateur_id")
	public UtilisateurBo getUtilisateurBo() {
		return utilisateurBo;
	}
	public void setUtilisateurBo(UtilisateurBo utilisateurBo) {
		this.utilisateurBo = utilisateurBo;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="topo_id")
	public TopoBo getTopoBo() {
		return topoBo;
	}
	public void setTopoBo(TopoBo topoBo) {
		this.topoBo = topoBo;
	}
	public Date getDt_reservation() {
		return dt_reservation;
	}
	public void setDt_reservation(Date dt_reservation) {
		this.dt_reservation = dt_reservation;
	}
	public Byte getValider() {
		return valider;
	}
	public void setValider(Byte valider) {
		this.valider = valider;
	}
	
}
