package com.mycompany.demo.persist;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "persist_manytomany_canal")
public class Canal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descripcion;
	private String emisora;
	private String localidad;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "persist_manytomany_televisor_canal", 
					joinColumns = {@JoinColumn(name="cana_id")}, 
					inverseJoinColumns = {@JoinColumn(name="tele_id")})
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<Televisor> televisores;
	
	public Canal() {
	}
	
	public Canal(String descripcion, String emisora, String localidad) {
		super();
		this.descripcion = descripcion;
		this.emisora = emisora;
		this.localidad = localidad;
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

	public String getEmisora() {
		return emisora;
	}

	public void setEmisora(String emisora) {
		this.emisora = emisora;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Collection<Televisor> getTelevisores() {
		return televisores;
	}

	public void setTelevisores(Collection<Televisor> televisores) {
		this.televisores = televisores;
	}

}
