package com.mycompany.demo.persist;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="persist_subitem")
public class SubItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descripcion;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Estilo> estilos;

	
	public SubItem() {
	}
	
	
	public SubItem(String descripcion) {
		super();
		this.descripcion = descripcion;
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

	public List<Estilo> getEstilos() {
		return estilos;
	}

	public void setEstilos(List<Estilo> estilos) {
		this.estilos = estilos;
	}
	
	
	
}
