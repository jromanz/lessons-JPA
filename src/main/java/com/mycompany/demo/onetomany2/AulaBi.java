package com.mycompany.demo.onetomany2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "one_to_many_aulabi")
public class AulaBi {
	@Id
	@GeneratedValue
	private Long id;
	private String descripcion;
	
	@OneToMany(mappedBy="aulaBi")
	List<EstudianteBi> estudiantes;
	
	public AulaBi() {
	}
	
	public AulaBi(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public AulaBi(String descripcion, List<EstudianteBi> estudiantes) {
		super();
		this.descripcion = descripcion;
		this.estudiantes = estudiantes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<EstudianteBi> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<EstudianteBi> estudiantes) {
		this.estudiantes = estudiantes;
	}

}
