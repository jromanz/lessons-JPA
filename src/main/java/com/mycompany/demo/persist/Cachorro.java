package com.mycompany.demo.persist;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persist_cachorro")
public class Cachorro implements Serializable {

	private static final long serialVersionUID = -5144986489114839416L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String raza;
	private String nombre;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	private Doctor doctorCachorro;

	public Cachorro() {
	}

	public Cachorro(String raza, String nombre) {
		super();
		this.raza = raza;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Doctor getDoctor() {
		return doctorCachorro;
	}

	public void setDoctor(Doctor doctor) {
		this.doctorCachorro = doctor;
	}

	@Override
	public String toString() {
		return "Cachorro [id=" + id + "]";
	}

}
