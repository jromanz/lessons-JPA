package com.mycompany.demo.persist;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "persist_jpql_alumno")
public class AlumnoPostGrado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dni;
	private String nombre;
	private Double peso;
	@Column(name = "fechaNacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNac;

	@ManyToMany(mappedBy = "alumnos")
	private List<CursoPostGrado> cursos;

	public AlumnoPostGrado() {
	}

	public AlumnoPostGrado(int id) {
		super();
		this.id = id;
	}

	public AlumnoPostGrado(String dni, String nombre, Double peso, Date fechaNac) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.peso = peso;
		this.fechaNac = fechaNac;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public List<CursoPostGrado> getCursos() {
		return cursos;
	}

	public void setCursos(List<CursoPostGrado> cursos) {
		this.cursos = cursos;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	@Override
	public String toString() {
		return "AlumnoPostGrado [dni=" + dni + ", nombre=" + nombre + ", peso="
				+ peso + ", fechaNac=" + fechaNac + "]";
	}





}
