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
@Table(name = "persist_laptop")
public class Laptop implements Serializable {

	private static final long serialVersionUID = 7922405154754952289L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marca;
	private String descripcion;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	private Doctor doctorLaptop;

	public Laptop() {
	}

	public Laptop(String marca, String descripcion) {
		super();
		this.marca = marca;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Doctor getDoctor() {
		return doctorLaptop;
	}

	public void setDoctor(Doctor doctor) {
		this.doctorLaptop = doctor;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + "]";
	}

}
