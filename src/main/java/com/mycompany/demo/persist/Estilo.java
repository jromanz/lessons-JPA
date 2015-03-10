package com.mycompany.demo.persist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="persist_estilo")
public class Estilo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="estilo_id")
	private SubItem subItem;

	public Estilo() {
	}
	
	public Estilo(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Estilo(Integer id, String descripcion, SubItem subItem) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.subItem = subItem;
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

	public SubItem getSubItem() {
		return subItem;
	}

	public void setSubItem(SubItem subItem) {
		this.subItem = subItem;
	}
	
	
	
}
