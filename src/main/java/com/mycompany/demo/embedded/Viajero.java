package com.mycompany.demo.embedded;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@IdClass(ViajeroId.class)
public class Viajero {
	@Id
	private String dni;
	@Id
	private String pasaporte;
	@Id
	@OneToOne
	@JoinColumn(name = "codigo_id")
	private CodigoUnico codigoUnico;
	@Id
	@OneToOne
	@JoinColumn(name = "artista_id")
	private Artista artista;

	private String nombre;
	private String pais;

	public Viajero() {
	}

	public Viajero(String nombre, String pais) {
		super();
		this.nombre = nombre;
		this.pais = pais;
	}

	public CodigoUnico getCodigoUnico() {
		return codigoUnico;
	}

	public void setCodigoUnico(CodigoUnico codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}

}
