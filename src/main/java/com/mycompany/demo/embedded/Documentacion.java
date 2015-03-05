package com.mycompany.demo.embedded;

import javax.persistence.Embeddable;

@Embeddable
public class Documentacion {
	
	private String rg;
	private String ordenExpedicion;
	private String seccion;
	private String zona;
	private String nacionalidad;
	
	public Documentacion() {
	}

	public Documentacion(String rg, String ordenExpedicion, String seccion,
			String zona, String nacionalidad) {
		super();
		this.rg = rg;
		this.ordenExpedicion = ordenExpedicion;
		this.seccion = seccion;
		this.zona = zona;
		this.nacionalidad = nacionalidad;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrdenExpedicion() {
		return ordenExpedicion;
	}

	public void setOrdenExpedicion(String ordenExpedicion) {
		this.ordenExpedicion = ordenExpedicion;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

}
