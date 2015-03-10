package com.mycompany.demo.persist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="persist_motor")
public class Motor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	
	@OneToOne(mappedBy="motor")
	private Omnibus omnibus;

	public Motor() {
	}

	public Motor(String descripcion, Omnibus omnibus) {
		super();
		this.descripcion = descripcion;
		this.omnibus = omnibus;
	}

	public Motor(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Omnibus getOmnibus() {
		return omnibus;
	}

	public void setOmnibus(Omnibus omnibus) {
		this.omnibus = omnibus;
	}

	
}
