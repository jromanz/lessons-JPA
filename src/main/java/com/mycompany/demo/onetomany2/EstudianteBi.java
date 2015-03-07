package com.mycompany.demo.onetomany2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "one_to_many_estudiantebi")
public class EstudianteBi {
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="aulabi_id")
	private AulaBi aulaBi;

	public EstudianteBi() {
	}
	
	public EstudianteBi(String nombre) {
		super();
		this.nombre = nombre;
	}

	public EstudianteBi(String nombre, AulaBi aulaBi) {
		super();
		this.nombre = nombre;
		this.aulaBi = aulaBi;
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

	public AulaBi getAulaBi() {
		return aulaBi;
	}

	public void setAulaBi(AulaBi aulaBi) {
		this.aulaBi = aulaBi;
	}

}
