package com.mycompany.demo.persist;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table(name="persist_jpql_curso")
@NamedQueries({
	@NamedQuery(name="CursoPostGrado.findByCode",
			query="select c from CursoPostGrado c where c.codigo = :codigo"),
	@NamedQuery(name="CursoPostGrado.findByName",
			query="select c from CursoPostGrado c where c.nombre like :nombre")
})
@SqlResultSetMapping(name="CursoPostGrado.CURSO_ALUMNO_MAPPING",
	entities={
				@EntityResult(entityClass=CursoPostGrado.class)
				},
	columns={	
				@ColumnResult(name="alumnito_id")
})
public class CursoPostGrado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String codigo;
	private String nombre;
	private String descripcion;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="persist_jpql_curso_alumno",
				joinColumns=@JoinColumn(name="curso_id"),
				inverseJoinColumns=@JoinColumn(name="alumno_id")
			)
	private List<AlumnoPostGrado> alumnos;

	public CursoPostGrado() {
	}
	
	public CursoPostGrado(String codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public CursoPostGrado(String nombre, String descripcion,
			List<AlumnoPostGrado> alumnos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.alumnos = alumnos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<AlumnoPostGrado> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<AlumnoPostGrado> alumnos) {
		this.alumnos = alumnos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "CursoPostGrado [id=" + id + ", codigo=" + codigo + ", nombre="
				+ nombre + ", descripcion=" + descripcion + "]";
	}
	
}
