package com.mycompany.demo.embedded;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Artista {
	@Id
	private int id;
	private String nombre;
	private String nombreArtistico;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreArtistico() {
		return nombreArtistico;
	}

	public void setNombreArtistico(String nombreArtistico) {
		this.nombreArtistico = nombreArtistico;
	}

}
