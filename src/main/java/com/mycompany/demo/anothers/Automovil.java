package com.mycompany.demo.anothers;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Automovil implements Serializable {

	private static final long serialVersionUID = 7032199550439391807L;
	@Id
	@Basic(optional=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Long id;
	@OneToMany(mappedBy = "automovil")
	private List<Foto> fotos;
	@Min(1900)
	private Integer anoFabricacion;
	@Min(1900)
	private Integer anoModelo;
	private Float precio;
	private Float kilometraje;
	@Column(nullable = false, updatable = false)
	private String observaciones;
	@ElementCollection
	@Column(length=20)
	private List<String> tags;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAnoFabricacion() {
		return anoFabricacion;
	}

	public void setAnoFabricacion(Integer anoFabricacion) {
		this.anoFabricacion = anoFabricacion;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Float getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(Float kilometraje) {
		this.kilometraje = kilometraje;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Automovil other = (Automovil) obj;
		if (this.id != other.id
				&& (this.id == null || !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Automovil [id=" + id + ", anoFabricacion=" + anoFabricacion
				+ ", anoModelo=" + anoModelo + ", precio=" + precio
				+ ", kilometraje=" + kilometraje + ", observaciones="
				+ observaciones + "]";
	}

}
