package com.mycompany.demo.keycomposite;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(AlumnoPK.class)
public class Alumno {
	@Id
	private String nombre;
	@Id
	private String dni;

	private String observaciones;

	public Alumno() {
	}

	public Alumno(String nombre, String dni, String observaciones) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.observaciones = observaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", dni=" + dni + ", observaciones="
				+ observaciones + "]";
	}
	
}
