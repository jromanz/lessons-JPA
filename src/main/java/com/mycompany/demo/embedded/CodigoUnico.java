package com.mycompany.demo.embedded;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CodigoUnico {
	
	@Id
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRegistro;
	private String codigoUnicoHash;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateRegistro() {
		return dateRegistro;
	}
	public void setDateRegistro(Date dateRegistro) {
		this.dateRegistro = dateRegistro;
	}
	public String getCodigoUnicoHash() {
		return codigoUnicoHash;
	}
	public void setCodigoUnicoHash(String codigoUnicoHash) {
		this.codigoUnicoHash = codigoUnicoHash;
	}
	
}
