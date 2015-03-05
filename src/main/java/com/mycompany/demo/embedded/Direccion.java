package com.mycompany.demo.embedded;

import javax.persistence.Embeddable;

@Embeddable
public class Direccion {
	private String direccion;
	private String cp;
	private String ciudad;
	private String uf;
	
	public Direccion() {
	}
	
	public Direccion(String direccion, String cp, String ciudad, String uf) {
		super();
		this.direccion = direccion;
		this.cp = cp;
		this.ciudad = ciudad;
		this.uf = uf;
	}


	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
}
