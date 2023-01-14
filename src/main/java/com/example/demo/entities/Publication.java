package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name= "type_mbr", discriminatorType = DiscriminatorType.STRING,length = 3)
public class Publication implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String titre;
	private String lien;
	@Temporal(TemporalType.DATE)  //Date fiha juste les 3 champs
	private Date date;
	private String sourcepdf;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSourcepdf() {
		return sourcepdf;
	}
	public void setSourcepdf(String sourcepdf) {
		this.sourcepdf = sourcepdf;
	}
	
	public Publication(String type, String titre, String lien, Date date, String sourcepdf) {
		super();
		this.type = type;
		this.titre = titre;
		this.lien = lien;
		this.date = date;
		this.sourcepdf = sourcepdf;
	}
	
	public Publication() { //obligatoire
		super();
	}

}
