package com.mycompany.demo.persist;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persist_omnibus")
public class Omnibus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Motor motor;

	public Omnibus() {
	}
	
	public Omnibus(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Omnibus(String nombre, Motor motor) {
		super();
		this.nombre = nombre;
		this.motor = motor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

}
