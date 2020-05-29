package org.openclassroom.escalade.model;

public class TopoBo {
	private Integer Id;
	private String nom;
	private String description;
	private String lieu;
	private Integer date;
	private Boolean dispo;
	
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
	public Integer getDate() {
		return date;
	}
	public void setDate(Integer date) {
		this.date = date;
	}
	public Boolean getDispo() {
		return dispo;
	}
	public void setDispo(Boolean dispo) {
		this.dispo = dispo;
	}
	
	

}
