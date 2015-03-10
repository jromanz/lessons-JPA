package com.mycompany.demo.manytomany2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="many_to_many_profesor1")
public class Profesor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@ManyToMany
	@JoinTable(name="many_to_many_profesor_curso1")
	private List<Curso> cursos;
	
	public Profesor() {
	}
	
	public Profesor(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Profesor(String nombre, List<Curso> cursos) {
		super();
		this.nombre = nombre;
		this.cursos = cursos;
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

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", cursos="
				+ cursos + "]";
	}
	
	
	
}
