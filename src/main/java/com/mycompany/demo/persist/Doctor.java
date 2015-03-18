package com.mycompany.demo.persist;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "persist_doctor")
public class Doctor implements Serializable {

	private static final long serialVersionUID = 8999358648540629784L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private int id;
	private String dni;
	private String nombre;

	@OneToMany(mappedBy = "doctorLaptop", cascade = CascadeType.PERSIST)
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<Laptop> laptops;

	@OneToMany(mappedBy = "doctorCachorro", cascade = CascadeType.PERSIST)
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<Cachorro> cachorros;

	public Doctor() {
	}

	public Doctor(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Laptop> getLaptops() {
		return laptops;
	}

	public void setLaptops(Collection<Laptop> laptops) {
		this.laptops = laptops;
	}

	public Collection<Cachorro> getCachorros() {
		return cachorros;
	}

	public void setCachorros(Collection<Cachorro> cachorros) {
		this.cachorros = cachorros;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", dni=" + dni + ", nombre=" + nombre + "]";
	}

}
