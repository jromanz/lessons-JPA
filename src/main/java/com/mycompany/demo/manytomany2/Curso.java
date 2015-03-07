package com.mycompany.demo.manytomany2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="many_to_many_curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@ManyToMany(mappedBy="cursos")
	private List<Profesor> profesores;
	
	public Curso() {
	}

	public Curso(String nombre) {
		super();
		this.nombre = nombre;
	}


	public Curso(String nombre, List<Profesor> profesores) {
		super();
		this.nombre = nombre;
		this.profesores = profesores;
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

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
	
	
}
