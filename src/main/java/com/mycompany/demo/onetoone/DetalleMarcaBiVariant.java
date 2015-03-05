package com.mycompany.demo.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DetalleMarcaBiVariant {

	@Id
	@GeneratedValue
	private Long id;
	@OneToOne(mappedBy="detalleMarcaBiVariant",cascade=CascadeType.ALL)
	private MarcaBiVariant marcaBiVariant;
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public DetalleMarcaBiVariant() {
	}
	
	public DetalleMarcaBiVariant(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public DetalleMarcaBiVariant(Long id, MarcaBiVariant marcaBiVariant,
			String descripcion) {
		super();
		this.id = id;
		this.marcaBiVariant = marcaBiVariant;
		this.descripcion = descripcion;
	}

	public DetalleMarcaBiVariant(MarcaBiVariant marcaBiVariant,
			String descripcion) {
		super();
		this.marcaBiVariant = marcaBiVariant;
		this.descripcion = descripcion;
	}

	public MarcaBiVariant getMarcaBiVariant() {
		return marcaBiVariant;
	}

	public void setMarcaBiVariant(MarcaBiVariant marcaBiVariant) {
		this.marcaBiVariant = marcaBiVariant;
	}

}
