package com.mycompany.demo.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DetalleMarca{
	
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private Marca marca;
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public DetalleMarca() {
	}
	
	public DetalleMarca(Long id, Marca marca, String descripcion) {
		super();
		this.id = id;
		this.marca = marca;
		this.descripcion = descripcion;
	}

	public DetalleMarca(Marca marca, String descripcion) {
		super();
		this.marca = marca;
		this.descripcion = descripcion;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
}
