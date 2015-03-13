package com.mycompany.demo.persist;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persist_manytomany_televisor")
public class Televisor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descripcion;
	private String modelo;
	private String marca;
	private String serie;

	@ManyToMany(mappedBy = "televisores")
	private Collection<Canal> canales;

	public Televisor() {
	}
	
	public Televisor(String descripcion, String modelo, String marca,
			String serie) {
		super();
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.marca = marca;
		this.serie = serie;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Collection<Canal> getCanales() {
		return canales;
	}

	public void setCanales(Collection<Canal> canales) {
		this.canales = canales;
	}

}
