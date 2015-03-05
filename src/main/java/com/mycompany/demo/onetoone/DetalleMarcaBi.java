package com.mycompany.demo.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DetalleMarcaBi{
	
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne(cascade=CascadeType.ALL)
	private MarcaBi marcaBi;
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public DetalleMarcaBi() {
	}
	
	public DetalleMarcaBi(Long id, MarcaBi marcaBi, String descripcion) {
		super();
		this.id = id;
		this.marcaBi = marcaBi;
		this.descripcion = descripcion;
	}

	public DetalleMarcaBi(MarcaBi marcaBi, String descripcion) {
		super();
		this.marcaBi = marcaBi;
		this.descripcion = descripcion;
	}

	public MarcaBi getMarcaBi() {
		return marcaBi;
	}

	public void setMarcaBi(MarcaBi marcaBi) {
		this.marcaBi = marcaBi;
	}
	
}
